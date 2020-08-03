package edi.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edi.entity.Company;
import edi.entity.Rating;
import edi.entity.Source;

@Repository("edifyerRepository")
public interface EdifyerDAO {
	
	public Company getCompany(int theId);
	
	public List<Company> getCompanies();
	
	public List<Source> getSources();

	public List<Rating> getRatings();

	public List<Company> search(@Param("keyword") String keyword);
}
