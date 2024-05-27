package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaIMPL implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaIMPL(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query= entityManager.createQuery("SELECT s FROM Employee s",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
         return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
       Employee employee=getEmployee(id);
       entityManager.remove(employee);
    }
}
