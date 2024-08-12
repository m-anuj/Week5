package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MemberShipDAO;
import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MemberShipDAO theMemberShipDAO,
											   TrafficFortuneService theTrafficFortuneService){
		return runner -> {
			//demoTheBeforeAdvice(theAccountDAO,theMemberShipDAO);
			
			//demoTheAfterReturningAdvice(theAccountDAO);
			
			//demoTheAfterThrowingAdvice(theAccountDAO);

			//demoTheAfterAdvice(theAccountDAO);
			
			demoTheAroundService(theTrafficFortuneService);
		};
	}

	private void demoTheAroundService(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundService");
		System.out.println("Calling the getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("\nMy Fortune is: "+data);
		System.out.println("\nFinished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		//Calling the findAccount method

		List<Account> theAccounts = null;

		try{
			//add a boolean to simulate exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("Main Program: .......caught exception: "+exc);
		}
		//Displaying the Accounts
		System.out.println("Main Program: demoTheAfterThrowingAdvice");
		System.out.println("----------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		//Calling the findAccount method

		List<Account> theAccounts = null;

		try{
			//add a boolean to simulate exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("Main Program: .......caught exception: "+exc);
		}
		//Displaying the Accounts
		System.out.println("Main Program: demoTheAfterThrowingAdvice");
		System.out.println("----------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		//Calling the findAccount method

		List<Account> theAccounts = theAccountDAO.findAccounts();

		//Displaying the Accounts

		System.out.println("Main Program: demotheAfterReturningAdvice");
		System.out.println("----------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MemberShipDAO theMemberShipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Anuj");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();

		//Calling the AccountDAO getter/setter

		theAccountDAO.setName("Anuj");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		//Calling the membership business method
		theMemberShipDAO.addSillyMember();
		theMemberShipDAO.goTOSleep();
	}

}
