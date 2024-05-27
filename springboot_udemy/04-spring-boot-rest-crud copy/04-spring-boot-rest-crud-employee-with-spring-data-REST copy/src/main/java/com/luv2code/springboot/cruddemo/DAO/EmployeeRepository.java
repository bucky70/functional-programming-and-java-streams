package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")//insteadof /employees we now get /members
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {//entity=employee, primarykey=integer
//no need to write any code
}
