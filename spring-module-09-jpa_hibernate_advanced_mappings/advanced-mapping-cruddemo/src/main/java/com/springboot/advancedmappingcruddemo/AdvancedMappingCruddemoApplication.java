package com.springboot.advancedmappingcruddemo;

import com.springboot.advancedmappingcruddemo.dao.AppDAO;
import com.springboot.advancedmappingcruddemo.entity.Course;
import com.springboot.advancedmappingcruddemo.entity.Instructor;
import com.springboot.advancedmappingcruddemo.entity.InstructorDetail;
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

			deleteCourse(appDAO);
		};
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