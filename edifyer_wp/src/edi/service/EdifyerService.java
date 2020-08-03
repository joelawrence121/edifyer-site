package edi.service;

import java.util.List;
import edi.entity.Company;
import edi.entity.Rating;
import edi.entity.Source;

public interface EdifyerService {

	public List<Company> getAllCompanies();

	public Company getCompany(int theId);

	public List<Source> getAllSources();

	public List<Rating> getAllRatings();

	public List<Company> search(String parameter);

	public Company getCompany(String company);

}
