package edi.service;

import java.util.List;
import edi.entity.Company;
import edi.entity.Rating;
import edi.entity.Source;

public interface EdifyerService {

	public List<Company> getCompanies();

	public Company getCompany(int theId);

	public List<Source> getSources();

	public List<Rating> getRatings();

	public List<Company> search(String parameter);
}
