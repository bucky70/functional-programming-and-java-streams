package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    //inject dao of employee
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    //expose /employees endpoint
    @GetMapping("/employees")
        public List<Employee> findAll(){
            return employeeService.findAll();
        }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        Employee employee= employeeService.getEmployee(id);
        if(employee==null){
            throw new RuntimeException("no employee found with that id");
        }
        return employee;
    }
    //post mapping for adding employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee=employeeService.insertEmployee(employee);
        return dbEmployee;
    }

    //add mapping for put /employee update existing exployee
    @PutMapping("/employees")
    public  Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee=employeeService.insertEmployee(employee);
        return dbEmployee;
    }
    //add mapping for delete /employee/{id}
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee dbEmployee=getEmployee(id);
        if(dbEmployee==null){
            throw new RuntimeException("no such employee found"+id);
        }
        employeeService.deleteEmployee(id);
        return  "employee with id "+id+" is deleyed";
    }

}
