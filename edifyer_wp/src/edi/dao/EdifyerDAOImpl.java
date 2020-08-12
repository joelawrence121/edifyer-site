package edi.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edi.entity.Company;
import edi.entity.CompanyLog;
import edi.entity.Rating;
import edi.entity.Source;

@Repository
public class EdifyerDAOImpl implements EdifyerDAO {

	// need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Company> getAllCompanies() {
		
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create the query 
		Query<Company> theQuery = currentSession.createQuery("from Company", Company.class);
		
		// get the result list 
		List<Company> companies = theQuery.getResultList();
		
		// return result
		return companies;
	}


	@Override
	public Company getCompany(int theId) {
		
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the company 
		Company theCompany = currentSession.get(Company.class, theId);
		
		// return the company 
		return theCompany;
	}


	@Override
	public List<Source> getAllSources() {
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create the query 
		Query<Source> theQuery = currentSession.createQuery("from Source", Source.class);
		
		// get the result list 
		List<Source> sources = theQuery.getResultList();
		
		// return result
		return sources;
	}


	@Override
	public List<Rating> getAllRatings() {
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create the query 
		Query<Rating> theQuery = currentSession.createQuery("from Rating", Rating.class);
		
		// get the result list 
		List<Rating> ratings = theQuery.getResultList();
		
		// return result
		return ratings;
	}


	@Override
	public List<Company> search(String keyword) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Company> theQuery = currentSession.createQuery("from Company where name like '%" + keyword+"%'", Company.class);
		List<Company> terms = theQuery.getResultList();
		return terms;
	}


	@Override
	public Company getCompany(String company) {
		
		// get current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find company by company name 
		Query<Company> theQuery = currentSession.createQuery("from Company where name = '" + company + "'", Company.class);
		
		// save company object into session 
		Company theCompany = theQuery.getSingleResult();
		
		// return the company 
		return theCompany;
	}


	@Override
	public void logSearch(Company theCompany) {
		
		// get current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get current date and convert into string 
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		
		// create new companyLog object
		CompanyLog theCompanyLog = new CompanyLog(theCompany.getId(), currentTime);
		
		// save into the session 
		currentSession.save(theCompanyLog);
		
	}


	@Override
	public List<Object[]> getRecentLogs() {
		
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get logs in the last 24 hours
		Query<Object[]> theQuery = currentSession.createNativeQuery("SELECT company.name, companyLog.date FROM companyLog, company "
				+ "WHERE company.id = companyLog.company_id AND companyLog.date >= sysdate() - 86400 "
				+ "ORDER BY companyLog.date DESC");
		
		// get the result list 
		List<Object[]> theCompanyLogs = theQuery.getResultList();
		
		return theCompanyLogs;
		
	}


	@Override
	public List<Object[]> getTopSearched() {
		
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
				
		// get logs in the last 24 hours
		Query<Object[]> theQuery = currentSession.createNativeQuery("SELECT company.name, count(companyLog.company_id) "
				+ "FROM companyLog, company "
				+ "WHERE company.id = companyLog.company_id "
				+ "GROUP BY companyLog.company_id "
				+ "ORDER BY count(companyLog.company_id) DESC").setMaxResults(5);
		
		// get the result list 
		List<Object[]> topSearched = theQuery.getResultList();
				
		return topSearched;
	}


	@Override
	public List<Long> getLogStats() {
		
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
				
		// get logs in the last 24 hours	
		BigInteger pastDayResult = (BigInteger) currentSession.createNativeQuery("SELECT count(*)"
				+ " FROM companyLog WHERE companyLog.date >= sysdate() - 86400 ").getSingleResult();
		
		BigInteger pastWeekResult = (BigInteger) currentSession.createNativeQuery("SELECT count(*)"
				+ " FROM companyLog WHERE companyLog.date >= sysdate() - 604800 ").getSingleResult();
		
		BigInteger allTimeResult = (BigInteger) currentSession.createNativeQuery("SELECT count(*)"
				+ " FROM companyLog ").getSingleResult();
		
		// merge the results 
		List<Long> logStats = new ArrayList<>();
		logStats.add(pastDayResult.longValue());
		logStats.add(pastWeekResult.longValue());
		logStats.add(allTimeResult.longValue());
		
		return logStats;
	}

}
