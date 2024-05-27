package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor); //this will also save instructorDetail for that particular instructor
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        Instructor instructor=entityManager.find(Instructor.class,id);
        if(instructor==null){
            throw new RuntimeException("no instructor with such id"+ id);

        }
        return instructor;

    }

    @Override
    @Transactional
    public void deleteByInstructorId(Integer id) {
        Instructor instructor=findInstructorById(id);
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void saveInstructorDetail(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Integer id) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(Integer id) {
        InstructorDetail instructorDetail=findInstructorDetailById(id);
        System.out.println(instructorDetail);
        //remove associated object reference
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
       // entityManager.flush();
    }
}
