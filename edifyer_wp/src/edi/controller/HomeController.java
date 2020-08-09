package edi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edi.entity.Company;
import edi.entity.Source;
import edi.service.EdifyerService;

@Controller
public class HomeController {
	
	// inject the edifyer service
	@Autowired 
	private EdifyerService edifyerService;
	
	@RequestMapping("/companyNamesAutocomplete")
	@ResponseBody
	public List<String> companyNamesAutocomplete(@RequestParam(value="term", 
												 required=false, defaultValue="") String term){
		
		List<String> suggestions = new ArrayList<String>();
		suggestions.add("ABCDE");
		suggestions.add("ABCDEfgh");
		suggestions.add("ABCDEGHGHGHG");
		
		return suggestions;
	}
	
	@RequestMapping("find")
	public String findCompany(@RequestParam String company, Model theModel) {
				
		// get the company by name and store in model
		Company theCompany = edifyerService.getCompany(company);
		theModel.addAttribute("theCompany", theCompany);
	
		// redirect to rating page
		System.out.println("Added " + theCompany + " to the model. ");
		
		return "rating";	
	}
	
	@RequestMapping(value="/how", method = RequestMethod.GET)
	public String loadHow(Model theModel) {
		
		// add list of sources to the model
		
		List<Source> theSources = edifyerService.getAllSources();
		theModel.addAttribute("theSources", theSources);

		System.out.println("Added " + theSources + " to the model. ");
		
		return "how";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String loadAbout(Model theModel) {

		return "about";
	}

	
}
