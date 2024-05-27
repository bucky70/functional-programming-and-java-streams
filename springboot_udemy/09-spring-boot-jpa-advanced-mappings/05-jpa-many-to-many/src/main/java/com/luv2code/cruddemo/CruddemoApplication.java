package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.*;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
             //createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id=1;
		System.out.println("deleting student with id "+id);
		appDAO.deleteStudentById(id);
		System.out.println("deleted student id "+id);

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id=2;
		Student student = appDAO.findStudentAndCourseByStudentId(id);
		Course course1=new Course("ribiks cube- how to speed cube");
		Course course2=new Course("game development");
		student.addCourse(course1);
		student.addCourse(course2);
		appDAO.update(student);
		System.out.println("student details :"+student);
		System.out.println("student courses :"+student.getCourse());

	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id=2;
		Student student=appDAO.findStudentAndCourseByStudentId(id);
		System.out.println("student is : "+student);
		System.out.println("associated courses are :"+student.getCourse());
		System.out.println("done");
	}

	private void findCourseAndStudents(AppDAO appDAO) { //start with course
		int id=10;
		Course course=appDAO.findCourseAndStudentByCourseId(id);
		System.out.println("course is "+course);
		System.out.println("students : "+course.getStudents());
		System.out.println("done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		//create coursse
         Course course=new Course("pacman-how to score one million");
		//create students
        Student student1=new Student("saikumar","padamati","saikumarpadamati13@gmail.com");
		Student student2=new Student("sailaja","padamati","sailajapadamati25@gmail.com");
		Student student3=new Student("vittal","padamati","vittalpadamati08@gmail.com");

		//add students to course
        course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		//save the course and associated students
		System.out.println("saving the course "+course);
		System.out.println("associated students "+course.getStudents());

		appDAO.saveCourse(course);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id=10;
		System.out.println("deleteing course with id "+id);
		appDAO.deleteCourseById(id);
		System.out.println("deleted id "+id);
	}

	private void retreiveCopurseAndReviews(AppDAO appDAO) {
		int id=10;
		Course course =appDAO.findCourseAndReviewsByCourseId(10);
		List<Review> reviews = course.getReviews();
		System.out.println("done");
		System.out.println(course);
		System.out.println(reviews);
	}

	private void createCourseAndReviews(AppDAO appDAO) {
       Course course=new Course("pacman - how to score million points");
	   course.add(new Review("great course, liked it"));
	   course.add(new Review("awesome course, loved it"));
	   course.add(new Review("terrific course, enjoyed it"));
	   course.add(new Review("bakwas course, ammerpet level "));
	   System.out.println("saving course");
	   appDAO.saveCourse(course);
	   System.out.println("saved the course");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id=10;
		System.out.println("deleteing course "+id);
		appDAO.deleteCourseById(id);
		System.out.println("done");
	}

	private void updateCourse(AppDAO appDAO) {
		int id=10;
		Course course=appDAO.findCourseByID(id);
		course.setTitle("playing music");
		appDAO.updateCourse(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id=1;
		Instructor instructor=appDAO.findInstructorById(id);
		instructor.setLastName("padmavathi not");
		instructor.setEmail("saikumarpadmavathi@gmail.com");
		appDAO.update(instructor);
		System.out.println(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id=1;
		Instructor instructor=appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("instructor is "+instructor);
		System.out.println("courses are "+instructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id=1;
		Instructor instructor=appDAO.findInstructorById(1);
		System.out.println("instructor is "+instructor);
		//System.out.println(instructor.getCourses()); this will throw error as we are lazy loading
		List<Course> courses=appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);
		System.out.println("list of courses "+ instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor=new Instructor("nirmala", "padamati","nirmalapadamati25@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("http://www.luv2code.com/youtube","telugu teaching");

		instructor.setInstructorDetail(instructorDetail);
		Course course1=new Course("air guitar");
		Course course2=new Course("school tuitions");
		Course course3=new Course("paintings");

		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		System.out.println("saving the instructor "+instructor);
		System.out.println("the courses "+instructor.getCourses());
		appDAO.save(instructor);
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


	private void deleteUserById(AppDAO appDAO) {
		int id=1;
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
