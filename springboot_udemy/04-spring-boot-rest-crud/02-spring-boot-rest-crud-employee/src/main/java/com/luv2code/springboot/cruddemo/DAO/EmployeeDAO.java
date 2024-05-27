package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee getEmployee(Integer id);

    Employee insertEmployee(Employee employee);

    void deleteEmployee(Integer id);
}
