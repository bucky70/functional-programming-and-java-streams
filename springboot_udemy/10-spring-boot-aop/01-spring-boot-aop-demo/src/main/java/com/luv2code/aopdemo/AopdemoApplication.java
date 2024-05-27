package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMemberDAO){
		return runner->{
			demoTheBeforeAdvice(theAccountDAO, theMemberDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMemberDAO) {
		Account account=new Account();
		theAccountDAO.addAccount(account,true);

		//System.out.println("calling same method name calls the @Before advice");
		//theMemberDAO.addAccount();
		//System.out.println("calling it again calls the @Before advice");
		//theAccountDAO.addAccount();
		theAccountDAO.addSilly();
	}
}
