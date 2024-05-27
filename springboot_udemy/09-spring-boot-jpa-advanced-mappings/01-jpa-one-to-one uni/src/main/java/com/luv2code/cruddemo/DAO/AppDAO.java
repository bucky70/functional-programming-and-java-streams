package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(Integer id);
    void deleteByInstructorId(Integer id);
    //for instructor details table
    void saveInstructorDetail(InstructorDetail instructorDetail);
    InstructorDetail findInstructorDetailById(Integer id);
    void deleteInstructorDetailsById(Integer id);

}
