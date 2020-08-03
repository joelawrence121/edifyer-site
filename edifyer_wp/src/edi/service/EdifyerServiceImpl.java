package edi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edi.dao.EdifyerDAO;
import edi.entity.Company;
import edi.entity.Rating;
import edi.entity.Source;

@Service
public class EdifyerServiceImpl implements EdifyerService {

	// we have this because this layer allows for easy expansion for more DAOs
	
	@Autowired
	private EdifyerDAO edifyerDAO;
	
	@Override
	@Transactional
	public List<Company> getCompanies() {
		return edifyerDAO.getCompanies();	
	}

	@Override
	@Transactional
	public List<Source> getSources() {
		return edifyerDAO.getSources();
	}

	@Override
	@Transactional
	public List<Rating> getRatings() {
		return edifyerDAO.getRatings();
	}
	
	@Override
	@Transactional
	public Company getCompany(int theId) {
		return edifyerDAO.getCompany(theId);
	}

	@Override
	@Transactional
	public List<Company> search(String parameter) {
		return edifyerDAO.search(parameter);
	}

}
