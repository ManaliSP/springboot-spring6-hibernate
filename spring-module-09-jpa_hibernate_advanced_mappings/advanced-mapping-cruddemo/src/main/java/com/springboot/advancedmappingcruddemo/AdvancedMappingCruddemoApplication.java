package com.springboot.advancedmappingcruddemo;

import com.springboot.advancedmappingcruddemo.dao.AppDAO;
import com.springboot.advancedmappingcruddemo.entity.Instructor;
import com.springboot.advancedmappingcruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedMappingCruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingCruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);
		};
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
