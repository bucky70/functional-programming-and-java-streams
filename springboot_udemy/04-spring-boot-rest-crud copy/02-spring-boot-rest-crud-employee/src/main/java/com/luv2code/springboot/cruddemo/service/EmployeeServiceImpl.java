package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public Employee insertEmployee(Employee employee) {
        return employeeDAO.insertEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer id) {
        employeeDAO.deleteEmployee(id);
    }

}
