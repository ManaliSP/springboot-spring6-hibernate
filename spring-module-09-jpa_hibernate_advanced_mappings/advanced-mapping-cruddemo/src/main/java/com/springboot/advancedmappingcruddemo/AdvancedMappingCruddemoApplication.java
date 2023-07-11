package com.springboot.advancedmappingcruddemo;

import com.springboot.advancedmappingcruddemo.dao.AppDAO;
import com.springboot.advancedmappingcruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedMappingCruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingCruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);

//			findInstructorWithCourses(appDAO);

//			findCoursesForInstructor(appDAO);

//			findInstructorWithCoursesJoinFetch(appDAO);

//			updateInstructor(appDAO);

//			updateCourse(appDAO);

//			deleteCourse(appDAO);

//			createCourseAndReview(appDAO);

//			retrieveCourseAndReviews(appDAO);

//			createCourseAndStudents(appDAO);

//			findCourseAndStudents(appDAO);

//			findStudentAndCourses(appDAO);

			addMoreCoursesForStudent(appDAO);
		};
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int id = 2;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		// create more courses
		Course course1  = new Course("Rubik's Cube - How to Speed Cube");
		Course course2  = new Course("Atari 2600 - Game Development");

		// add courses to student
		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("Updating student: " + student);
		System.out.println("Associated courses: " + student.getCourses());

		appDAO.update(student);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int id = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Student: " + student);
		System.out.println("Associated courses: " + student.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int id = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Associated course: " + course.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course course  = new Course("Pacman - How To Score One Million Points");

		// create a students
		Student student1 = new Student("Manali", "Patil", "manali@gmail.com");
		Student student2 = new Student("John", "Doe", "john@gmail.com");

		// add students to the course
		course.addStudent(student1);
		course.addStudent(student2);

		// save the course and associated students
		System.out.println("Saving the course: " + course);
		System.out.println("Associated students: " + course.getStudents());

		appDAO.save(course);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int id = 10;

		// get the course and reviews
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		// print the course
		System.out.println("Course: " + course);

		// print the reviews
		System.out.println("Reviews: " + course.getReviews());

		System.out.println("Done!");
	}

	private void createCourseAndReview(AppDAO appDAO) {

		// create a course
		Course course  = new Course("Pacman - How To Score One Million Points");

		// add some reviews
		course.addReview(new Review("Great course ... loved it!"));
		course.addReview(new Review("Cool course, job well done."));
		course.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {

		int id = 10;

		System.out.println("Finding course id: " + id);

		// delete course
		appDAO.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {

		int id = 10;

		// find Course by id
		System.out.println("Finding course id: " + id);
		Course course = appDAO.findCourseById(id);

		// update title of the course
		System.out.println("Updating the course id: " + id);
		course.setTitle("Think of Good Things");

		appDAO.update(course);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {

		int id = 1;

		// find the instructor
		System.out.println("Finding instructor by id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		// update the instructor
		System.out.println("Updating instructor id: " + id);
		instructor.setLastName("TESTER");

		appDAO.update(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor by id: " + id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor by id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("The associated courses: " + instructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor by id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Associated Courses: " + instructor.getInstructorDetail());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor instructor = new Instructor("susan", "Public", "susan@gmail.com");

		// create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "Video Games");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course course1  = new Course("Air Guitar - The Ultimate Guide");
		Course course2  = new Course("The Pinball Masterclass");

		instructor.add(course1);
		instructor.add(course2);

		// save the instructor
		// NOTE: this will ALSO save the courses because of CascadeType.PERSIST
		//
		System.out.println("Saving Instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		appDAO.save(instructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO){

		int id = 2;
		System.out.println("Deleting instructor id: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO){

		// get the instructor detail object
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		// print the instructor detail
		System.out.println("Instructor detail: " + instructorDetail);

		// print the associated instructor
		System.out.println("Associated instructor:  " + instructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO){

		int id = 1;
		System.out.println("Deleting instructor id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO){
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("The associate instructorDetail only: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO){

		// create the instructor
		Instructor instructor = new Instructor("Manali", "Patil", "manali@gmail.com");

		// create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "Love to code!!!");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		// NOTE: This will also save the details object because of CascadeType.ALL
		System.out.println("Saving instructor : " + instructor);
		appDAO.save(instructor);
	}
}
