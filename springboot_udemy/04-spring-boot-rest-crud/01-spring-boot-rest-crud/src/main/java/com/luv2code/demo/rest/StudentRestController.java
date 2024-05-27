package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;
    @PostConstruct
    public void loadData(){
        Student student1=new Student("saikumar","padamati");
        Student student2=new Student("sailaja","padamati");
        Student student3=new Student("vittal","padamati");

        students=new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }
    //endpoint for /student -> returns all students
    @GetMapping("/student")
    public List<Student> getStudents(){
        return students;
    }

    //endpoint for retreiving student details based on id
    @GetMapping("/student/{studentid}")
    public Student getStudentByID(@PathVariable Integer studentid){//this should match with the path variable
        //check index of the list

        //check student id in list
        if(studentid>=students.size() || studentid<0){
            throw new StudentNotFoundException("no such studentID found "+studentid);
        }
        return students.get(studentid);
    }
    //add exception handler


}
