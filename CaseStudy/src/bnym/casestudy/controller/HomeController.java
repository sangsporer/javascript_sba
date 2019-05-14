/**
 * 
 */
package bnym.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author sang.sporer
 *
 */

@Controller
public class HomeController {
	
	//home page
	@RequestMapping(value = "/")
	public ModelAndView login() {
			ModelAndView model = new ModelAndView("index");
			return model;		
	}
	
	//from home takes you to log in page for all users
	@RequestMapping(value = "/admin")
	public ModelAndView adminLogin() {
		ModelAndView model = new ModelAndView("adminLogin");
		return model;
	}
	
	@RequestMapping(value = "/donor")
	public ModelAndView donorLogin() {
		ModelAndView model = new ModelAndView("donorLogin");
		return model;
	}
	
	@RequestMapping(value = "/trustee")
	public ModelAndView trusteeLogin() {
		ModelAndView model = new ModelAndView("trusteeLogin");
		return model;
	}
	
	@RequestMapping(value = "/new")
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("newUser");
		return model;
	}

	
}
