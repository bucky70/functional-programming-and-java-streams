package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        for(Course course:instructor.getCourses()){//dereferencing the courses from instructor before deleteion
            course.setInstructor(null);
        }
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

    @Override
    public List<Course> findCoursesByInstructorId(Integer id) {
       // Instructor instructor=findInstructorById(id);
        TypedQuery<Course> query= entityManager.createQuery("Select c from Course c where instructor.id=:id", Course.class);
        query.setParameter("id",id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Integer id) {
        TypedQuery<Instructor> query= entityManager.createQuery("Select i from Instructor i join fetch i.courses join fetch i.instructorDetail where i.id=:id", Instructor.class);
        query.setParameter("id",id);
        Instructor instructor=query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseByID(Integer id) {
       return  entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
       entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(Integer id) {
        Course course=findCourseByID(id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(Integer id) {
       TypedQuery<Course> query=entityManager.createQuery("select c from Course c join fetch c.reviews where c.id=:id",Course.class);
       query.setParameter("id", id);
       return query.getSingleResult();

    }
}
