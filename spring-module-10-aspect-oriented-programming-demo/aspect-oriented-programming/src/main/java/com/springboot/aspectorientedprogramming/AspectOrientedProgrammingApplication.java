package com.springboot.aspectorientedprogramming;

import com.springboot.aspectorientedprogramming.dao.AccountDAO;
import com.springboot.aspectorientedprogramming.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);

			demoTheAfterReturningAdvice(accountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		// call a business method findAccount()
		List<Account> accounts = accountDAO.findAccounts();

		// display accounts
		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// call the business method
		Account account =  new Account();
		account.setName("Manali");
		account.setLevel("Senior");
		accountDAO.addAccount(account, true);
		accountDAO.addAnotherAccount();

		// call the accountdao getter/setter
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		// call membership business method
		membershipDAO.addAccount();
		membershipDAO.isAccountAvailable();
	}
}
