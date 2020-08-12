package edi.bop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edi.entity.Company;
import edi.service.EdifyerService;

@Aspect
@Component
public class DatabaseLoggingAspect {
	
	@Autowired
	private EdifyerService edifyerService; 
	
	// execute after returning on getCompany method in CompanyController 
	
	// insert new row into companyLog with the company id and datetime now 
	
	@AfterReturning(pointcut="execution(* edi.dao.EdifyerDAOImpl.getCompany(..))", 
					returning="theCompany")
	public void logCompanySearch(JoinPoint theJoinPoint, Company theCompany) {
		
		System.out.println(">> Logging !");
		
		System.out.println(theCompany);
		
		edifyerService.logSearch(theCompany);
			
	}

}
