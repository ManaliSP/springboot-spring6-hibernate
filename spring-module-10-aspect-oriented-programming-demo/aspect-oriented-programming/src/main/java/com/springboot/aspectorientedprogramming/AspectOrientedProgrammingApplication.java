package com.springboot.aspectorientedprogramming;

import com.springboot.aspectorientedprogramming.dao.AccountDAO;
import com.springboot.aspectorientedprogramming.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// call the business method
		Account account =  new Account();
		accountDAO.addAccount(account, true);

		// call the business method
		accountDAO.addAnotherAccount();

		// call membership business method
		membershipDAO.addAccount();

		// call membership business method
		membershipDAO.isAccountAvailable();
	}
}
