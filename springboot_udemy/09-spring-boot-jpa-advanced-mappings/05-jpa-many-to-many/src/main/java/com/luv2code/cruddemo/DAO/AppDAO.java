package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(Integer id);
    void deleteByInstructorId(Integer id);
    //for instructor details table
    void saveInstructorDetail(InstructorDetail instructorDetail);
    InstructorDetail findInstructorDetailById(Integer id);
    void deleteInstructorDetailsById(Integer id);

    List<Course> findCoursesByInstructorId(Integer id);
    Instructor findInstructorByIdJoinFetch(Integer id);
    void update(Instructor instructor);

    Course findCourseByID(Integer id);
    void updateCourse(Course course);

    void deleteCourseById(Integer id);

    void saveCourse(Course course);
    Course findCourseAndReviewsByCourseId(Integer id);

    Course findCourseAndStudentByCourseId(Integer id);
    Student findStudentAndCourseByStudentId(Integer id);

    void update(Student student);
    void deleteStudentById(Integer id);


}
