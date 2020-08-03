package edi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edi.entity.Company;
import edi.entity.Rating;
import edi.entity.Source;
import edi.service.EdifyerService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	// inject the edifyer service
	@Autowired 
	private EdifyerService edifyerService;
	
	@GetMapping("/list")
	public String listCompanies(Model theModel) {
		
		// get all the companies, ratings, sources from the dao
		List<Company> theCompanies = edifyerService.getCompanies();
		List<Source> theSources = edifyerService.getSources();
		List<Rating> theRatings = edifyerService.getRatings();
		
		// add the data to the spring model 
		theModel.addAttribute("companies", theCompanies);
		theModel.addAttribute("sources", theSources);
		theModel.addAttribute("ratings", theRatings);
		
		return "list-companies";
	}
	
//	@GetMapping("/showFormForAdd")
//	public String showAddForm(Model theModel) {
//		
//		// create model attribute to bind form data
//		Customer theCustomer = new Customer();
//		
//		theModel.addAttribute("customer", theCustomer);
//		
//		return "customer-form";
//	}
//	
//	
//	@GetMapping("/showFormForUpdate")
//	public String showFormForUpdate(@RequestParam("customerId") int theId, 
//									Model theModel) {
//		
//		// get customer from service 
//		Customer theCustomer = customerService.getCustomer(theId);
//		
//		// set customer as a model attrbiute to pre populate the form 
//		theModel.addAttribute("customer", theCustomer);
//		
//		// send over to the form 
//		return "customer-form";
//	}
}
