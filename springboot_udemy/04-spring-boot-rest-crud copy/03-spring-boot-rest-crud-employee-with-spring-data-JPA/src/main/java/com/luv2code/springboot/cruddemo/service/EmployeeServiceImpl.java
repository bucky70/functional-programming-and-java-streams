package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    /*@Override
    public Optional<Employee> getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }*/
    @Override
    public Employee getEmployee(Integer id){
        Optional<Employee> result=employeeRepository.findById(id);
        Employee employee=null;
        if(result.isPresent()){
            employee=result.get();
        }
        else{
            throw new RuntimeException("did not find employee id "+id);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    //@Transactional  no need for this as jpa repository provides this out of the beox
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

}
