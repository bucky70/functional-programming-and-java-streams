package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//System.out.println("hello world");
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteUserById(appDAO);

			//findInstructorDetailsById(appDAO);
			//saveInstructorDetails(appDAO);
			deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int id=6;
		System.out.println("deleting user with id "+id);

		appDAO.deleteInstructorDetailsById(id);
		System.out.println("deleted user with id "+id);
	}

	private void findInstructorDetailsById(AppDAO appDAO) {
		int id=1;
		InstructorDetail instructorDetail=appDAO.findInstructorDetailById(id);
		System.out.println(instructorDetail.toString());
		System.out.println(instructorDetail.getInstructor().toString());
	}

	private void saveInstructorDetails(AppDAO appDAO) {
		Instructor instructor=new Instructor("sailaja", "padamati","saiklajapadamati25@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("http://www.luv2code.com/youtube","takes good care");
        instructorDetail.setInstructor(instructor);

		System.out.println("saving the instructordetail "+instructorDetail.toString());
		appDAO.saveInstructorDetail(instructorDetail);
		System.out.println("saved the instructor "+instructor.toString());
	}

	private void deleteUserById(AppDAO appDAO) {
		int id=3;
		System.out.println("deleting user "+id);
		appDAO.deleteByInstructorId(id);
		System.out.println(" user has been deleted"+id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("finding instructor by id");
		Instructor instructor=appDAO.findInstructorById(id);
		System.out.println(instructor.toString());
		System.out.println("the associated intructor details are " +instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
	//	Instructor instructor=new Instructor("saikumar", "Padamati","saikumarpadamati13@gmail.com");
	//	InstructorDetail instructorDetail=new InstructorDetail("http://www.luv2code.com/youtube","love to code");

		Instructor instructor=new Instructor("sailaja", "padamati","saiklajapadamati25@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("http://www.luv2code.com/youtube","takes good care");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("saving instructor with name "+instructor.getFirstName());

		appDAO.save(instructor);

		System.out.println("saving is done");
	}
}
