package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberShipDAO theMemberShipDAO){
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO,theMemberShipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MemberShipDAO theMemberShipDAO) {

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();

		//Calling the membership business method
		theMemberShipDAO.addSillyMember();
		theMemberShipDAO.goTOSleep();
	}

}
