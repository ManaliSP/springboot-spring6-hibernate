package com.springhibernate.jpacrud;

import com.springhibernate.jpacrud.Entity.Student;
import com.springhibernate.jpacrud.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list students
		List<Student> students = studentDAO.findByLastName("Doe");

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ..");
		Student student = new Student("Daffy", "Duck", "daffy@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(student);

		// display id of the saved student
		int studentId = student.getId();
		System.out.println("Saved student. Generated id : " + studentId);

		// retrieve student based on the id : primary key
		System.out.println("Retrieving student with id: " + studentId);
		Student retrievedStudent = studentDAO.findById(studentId);

		// display student
		System.out.println("Found the student : " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student student1 = new Student("John", "Doe","john@gmail.com");
		Student student2 = new Student("Mary", "Public","mary@gmail.com");
		Student student3 = new Student("Bonita", "Applebum","bonita@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Manali", "patil","manali@gmail.com");

		// save the student object
		System.out.println("Saving the student ....");
		studentDAO.save(student);

		// display the id of saved student
		System.out.println("Saved student. Generated Id: " + student.getId());
	}


}
