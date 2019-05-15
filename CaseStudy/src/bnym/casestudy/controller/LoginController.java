/**
 * 
 */
package bnym.casestudy.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bnym.casestudy.entity.Scholarship;
import bnym.casestudy.entity.User;
import bnym.casestudy.entity.Winner;
import bnym.casestudy.service.ScholarshipService;



/**
 * @author sang.sporer
 *
 */



@Controller
public class LoginController {
	
	@Autowired
	ScholarshipService scholarshipService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name="email") String email, 
			@RequestParam(name="password") String password, Model user) {
		
		
		if (!(email.equals("sang@gmail.com") && password.equals("12345"))) {
			ModelAndView model = new ModelAndView("redirect:/");
			model.addObject("msg", "Invalid Credentials");
			return model;
		}
		
		user.addAttribute("user", new User());	
		ModelAndView model = new ModelAndView("redirect:/scholarshipList");
		model.addObject("msg", "Login successful!");
		return model;
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam(name="email") String email, 
			@RequestParam(name="password") String password, Model user) {
		
		
		if (!(email.equals("admin@gmail.com") && password.equals("admin"))) {
			ModelAndView model = new ModelAndView("redirect:/");
			model.addObject("msg", "Invalid Credentials");
			return model;
		}
		
		user.addAttribute("user", new User());	
		ModelAndView model = new ModelAndView("adminServicePage");
		model.addObject("msg", "Login successful!");
		return model;
	}
	
	@RequestMapping(value = "/donorLogin", method = RequestMethod.POST)
	public ModelAndView donorLogin(@RequestParam(name="email") String email, 
			@RequestParam(name="password") String password, Model user) {
		
		
		if (!(email.equals("donor@gmail.com") && password.equals("donor"))) {
			ModelAndView model = new ModelAndView("redirect:/");
			model.addObject("msg", "Invalid Credentials");
			return model;
		}
		
		user.addAttribute("user", new User());	

		Scholarship scholarship = scholarshipService.getScholarshipById(1L);
		Collection<Winner> scholarshipWinnerList = scholarship.getWinners();
		
		ModelAndView model = new ModelAndView("scholarshipPage") ;
		model.addObject("scholarship", scholarship);

		model.addObject("scholarshipWinnerList", scholarshipWinnerList);
		model.addObject("msg", "Login successful!");
		return model;
	}
	@RequestMapping(value = "/trusteeLogin", method = RequestMethod.POST)
	public ModelAndView trusteeLogin(@RequestParam(name="email") String email, 
			@RequestParam(name="password") String password, Model user) {
		
		
		if (!(email.equals("trustee@gmail.com") && password.equals("trustee"))) {
			ModelAndView model = new ModelAndView("redirect:/");
			model.addObject("msg", "Invalid Credentials");
			return model;
		}
		
		user.addAttribute("user", new User());	

		
		ModelAndView model = new ModelAndView("scholarshipList");
		List<Scholarship> scholarshipList = scholarshipService.getAllScholarships();
		model.addObject("scholarshipList", scholarshipList);
		model.addObject("msg", "Login successful!");
		return model;
	}
	
	
	
	
	
}
