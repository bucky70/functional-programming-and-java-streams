package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.hibernate.internal.log.SubSystemLogging;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//findAllStudents(studentDAO);
			//findByLastNameQuery(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all students");
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("deleting student with id"+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retreive student based on id
		int id=2;
		Student student=studentDAO.findById(id);

		//change first name to scooby
        student.setFirstName("scooby");

		//merge/update it in database
        studentDAO.update(student);
		//display the updated results
		System.out.println(student);
	}

	private void findByLastNameQuery(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findByLastName("sharma");
		for(Student student:students){
			System.out.println(student);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findAll();
		for(Student student:students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
         //create student
		System.out.println("creating student details");
         Student student=new Student("akhil","sharma","akhilsharma21@gmail.com");
		//save the student
		System.out.println("saving student details");
        studentDAO.save(student);
		//display student details
        System.out.println(student.getFirstName()+" "+student.getLastName()+" "+student.getEmail()+" "+student.getId());
		//retreive student details based on primary key
		Student retreivedStudent=studentDAO.findById(student.getId());
		System.out.println(retreivedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create student object
		System.out.println("creating 3 students object");
		Student student1=new Student("vittal","padamati","saikumarpadamati13@gmail.com");
		Student student2=new Student("sailaja","padamati","saikumarpadamati13@gmail.com");
		Student student3=new Student("nirmala","padamati","saikumarpadamati13@gmail.com");

		System.out.println("saving student object");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create student object
		System.out.println("creating student object");
        Student student=new Student("saikumar","padamati","saikumarpadamati13@gmail.com");
		//save the student object
		System.out.println("saving student object");
        studentDAO.save(student);
		//display id of saved student
		System.out.println("saved student generated id= "+student.getId());
	}
}
