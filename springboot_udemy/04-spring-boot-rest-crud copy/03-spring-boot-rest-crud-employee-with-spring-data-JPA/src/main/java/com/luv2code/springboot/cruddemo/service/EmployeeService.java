package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    //get employee by id
    Employee getEmployee(Integer id);

    //insert/update employee
    Employee insertEmployee(Employee employee);

    //delete an existing employee
    void deleteEmployee(Integer id);
}
