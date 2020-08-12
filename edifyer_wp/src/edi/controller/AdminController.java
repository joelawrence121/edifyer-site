package edi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edi.entity.Company;
import edi.entity.CompanyLog;
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
		List<Company> theCompanies = edifyerService.getAllCompanies();
		List<Source> theSources = edifyerService.getAllSources();
		List<Rating> theRatings = edifyerService.getAllRatings();
		
		// add the data to the spring model 
		theModel.addAttribute("companies", theCompanies);
		theModel.addAttribute("sources", theSources);
		theModel.addAttribute("ratings", theRatings);
		
		return "list-companies";
	}
	
	@GetMapping("/analytics")
	public String getAnalytics(Model theModel) {
		
		// get the relevant stats from the dao 
		List<CompanyLog> recentLogs = edifyerService.getRecentLogs();
		Map<Company, Integer> topSearchedCompanies = edifyerService.getTopSearched();
		Map<String, Integer> logStats = edifyerService.getLogStats();
		
		
		// add the data to the spring model 
		theModel.addAttribute("recentLogs", recentLogs);
		theModel.addAttribute("topSearchedCompanies", topSearchedCompanies);
		theModel.addAttribute("logStats", logStats);
		
		return "analytics";
	}
}
