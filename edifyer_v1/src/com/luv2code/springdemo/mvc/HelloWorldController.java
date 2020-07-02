package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	// need a controller method to show initial HTML form 
	
	@RequestMapping("showRating")
	public String showRating() {
		return "rating";
	}
	
	@RequestMapping("/showFunct")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// controller method to read form data and add data to the model
	@RequestMapping("/processFormV2")
	public String getAllUpper(HttpServletRequest request, Model model) {
		
		// read request parameter from html form 
		//		studentName defined in HTML input form from view 
		String theName = request.getParameter("inputName");
		
		// convert into upper case
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey! " + theName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// controller method to read form data and add data to the model
	@RequestMapping("/processFormV3")
	public String getAllUpper(@RequestParam("inputName") String theName,
							  Model model) {
		
		// business logic
		theName = theName.toUpperCase();
		String result = "Hey from v3 " + theName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
