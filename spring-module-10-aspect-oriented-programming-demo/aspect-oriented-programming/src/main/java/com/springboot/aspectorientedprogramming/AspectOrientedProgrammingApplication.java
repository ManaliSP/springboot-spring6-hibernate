package com.springboot.aspectorientedprogramming;

import com.springboot.aspectorientedprogramming.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO){
		return runner -> {
			demoTheBeforeAdvice(accountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {

		// call the business method
		accountDAO.addAccount();
	}
}
