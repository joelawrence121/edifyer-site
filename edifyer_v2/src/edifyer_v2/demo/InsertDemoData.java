package edifyer_v2.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import edifyer_v2.entities.Company;
import edifyer_v2.entities.Rating;
import edifyer_v2.entities.Source;

public class InsertDemoData {

	public static void main(String[] args) {
		
		// create session factory 
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Company.class)
									.addAnnotatedClass(Rating.class)
									.addAnnotatedClass(Source.class)
									.buildSessionFactory();
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {				
			// start the transaction 
			session.beginTransaction();
			
		    // create companies 
			Company tempCompany1 = new Company("Nike", "Footwear");
			Company tempCompany2 = new Company("Apple", "Technology");
			System.out.println("Created companies ...");
					
			// create sources
			Source tempSource1 = new Source("GoodOnYou", "goodonyou_extractor.py", "goodonyou.com");
			Source tempSource2 = new Source("RatingsTime", "RatingsTime_extractor.py", "RatingsTime.com");
			Source tempSource3 = new Source("EU_ethics", "EU_ethics_extractor.py", "EU_ethics.com");
			System.out.println("Created sources ...");
			
			// create ratings
			Rating tempRating1 = new Rating(29.5, 3.0, new Date() ,"specific_url.com");
			System.out.println("Created rating ...");
			
			// link the rating to source and company 
			tempCompany1.addRating(tempRating1);
			tempSource1.addRating(tempRating1);
			System.out.println("Linked rating ...");
			
			// save the objects
			session.save(tempCompany1);
			session.save(tempSource1);
			session.save(tempRating1);
			System.out.println("Saved company: " + tempCompany1);
			System.out.println("Saved source: " + tempSource1);
			System.out.println("Saved rating: " + tempSource1);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
