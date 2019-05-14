/**
 * 
 */
package bnym.casestudy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bnym.casestudy.entity.User;



/**
 * @author sang.sporer
 *
 */

@Controller
public class LoginController {
	
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
	
	@RequestMapping(value = "/trusteeLogin", method = RequestMethod.POST)
	public ModelAndView trusteeLogin(@RequestParam(name="email") String email, 
			@RequestParam(name="password") String password, Model user) {
		
		
		if (!(email.equals("sang@gmail.com") && password.equals("12345"))) {
			ModelAndView model = new ModelAndView("redirect:/");
			model.addObject("msg", "Invalid Credentials");
			return model;
		}
		
		user.addAttribute("user", new User());	
		ModelAndView model = new ModelAndView("scholarshipList");
		model.addObject("msg", "Login successful!");
		return model;
	}
	
	
	
	
	
}
