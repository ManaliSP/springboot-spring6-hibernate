package com.springboot.aspectorientedprogramming;

import com.springboot.aspectorientedprogramming.dao.AccountDAO;
import com.springboot.aspectorientedprogramming.dao.MembershipDAO;
import com.springboot.aspectorientedprogramming.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService){
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);

//			demoTheAfterReturningAdvice(accountDAO);

//			demoTheAfterThrowingAdvice(accountDAO);

//			demoTheAfterAdvice(accountDAO);

//			demoTheAroundAdvice(trafficFortuneService);

//			demoTheAroundAdviceHandleException(trafficFortuneService);

			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n\n Main Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished!");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n\n Main Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished!");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n\n Main Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished!");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {

		// call a business method findAccount()
		List<Account> accounts = null;

		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exception){
			System.out.println("\n\n Main Program: caught exception: " +exception);
		}

		// display accounts
		System.out.println("\n\n Main Program: demoTheAfterAdvice");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {

		// call a business method findAccount()
		List<Account> accounts = null;

		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exception){
			System.out.println("\n\n Main Program: caught exception: " +exception);
		}


		// display accounts
		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");

		System.out.println(accounts);

		System.out.println("\n");
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
