package edi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edi.entity.Company;
import edi.service.EdifyerService;

@Controller
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	private EdifyerService edifyerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(@RequestParam(value="term", required=false,defaultValue="") String term) {
		
		List<String> suggestions = new ArrayList<String>();
		try {
			List<Company> companies = edifyerService.search(term);
			System.out.println(companies);
			for(Company tempComp : companies) {
				suggestions.add(tempComp.getName());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return suggestions;
	}

}
