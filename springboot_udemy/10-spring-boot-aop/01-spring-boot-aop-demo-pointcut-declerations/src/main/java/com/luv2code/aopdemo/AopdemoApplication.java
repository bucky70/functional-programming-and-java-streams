package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
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

		//setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		//getter methods
		String name=theAccountDAO.getName();
		String service=theAccountDAO.getServiceCode();

		//System.out.println("calling it again calls the @Before advice");
		//theAccountDAO.addAccount();
		theAccountDAO.addSilly();
	}
}
