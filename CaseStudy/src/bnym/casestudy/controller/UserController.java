/**
 * 
 */
package bnym.casestudy.controller;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bnym.casestudy.entity.User;
import bnym.casestudy.service.UserService;



/**
 * @author sang.sporer
 *
 */

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	//view all users
	@RequestMapping("/userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView("userList");
		List<User> userList = userService.getAllUsers();
		mav.addObject("userList", userList);
		return mav;
	}
	
	//add new user
	@RequestMapping("/newUser")
	public ModelAndView newUser(Model model) {
		model.addAttribute("user", new User());
		ModelAndView mav = new ModelAndView("newUser");
		mav.addObject("roles", User.Role.values());
		return mav;
	}
	
	
	//save user
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, 
			BindingResult result) {

//		if (result.hasErrors()) {
//			ModelAndView model = new ModelAndView("newUser");
//			return model;
//		}

		userService.saveUser(user);
		ModelAndView model = new ModelAndView("redirect:/userList");

		return model;

	}
	
	@RequestMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable Long id) {
		
		userService.deleteUserById(id);
		ModelAndView mav = new ModelAndView("redirect:/userList");
		return mav;
		
	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUserForm(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("editUser");
		User user = userService.getUserById(id);
		mav.addObject("headerMessage", "Edit User Details");
		mav.addObject("user", user);
		mav.addObject("roles", User.Role.values());
		return mav;
	}
	
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
	public ModelAndView saveEditedUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}

		userService.saveUser(user);
		ModelAndView model = new ModelAndView("redirect:/userList");

		return model;
	}
		
	
	
	
	
	
	
}
