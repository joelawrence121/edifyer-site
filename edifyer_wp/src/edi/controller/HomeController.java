package edi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String findCompany(@RequestParam String company) {
		System.out.println("Found: " + company);
		return "admin/list";
	}

	
}
