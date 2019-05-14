/**
 * 
 */
package bnym.casestudy.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import bnym.casestudy.entity.Scholarship;
import bnym.casestudy.entity.Winner;
import bnym.casestudy.service.ScholarshipService;
import bnym.casestudy.service.WinnerService;



/**
 * @author sang.sporer
 *
 */

@Controller
public class WinnerController {
	
	@Autowired
	WinnerService winnerService;
	
	@Autowired
	ScholarshipService scholarshipService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "year", new CustomDateEditor(sdf, false));
	}
	
	
	
	
	//view all winners
	@RequestMapping("/winnerList")
	public ModelAndView winnerList() {
		ModelAndView mav = new ModelAndView("winnerList");
		List<Winner> winnerList = winnerService.getAllWinners();
		mav.addObject("winnerList", winnerList);
		return mav;
	}
	
	//add new winner
	
//	@RequestMapping(value = "/newWinner/{id}", method = RequestMethod.GET)
//	public ModelAndView newWinnerForm(@PathVariable Long id, Model model) {
//		ModelAndView mav = new ModelAndView("newWinner");
//		model.addAttribute("winner",  new Winner());
//		Scholarship scholarship = scholarshipService.getScholarshipById(id);
//		mav.addObject("scholarship", scholarship);
//		return mav;
//	}
	@RequestMapping("/newWinner")
	public ModelAndView newWinner(Model model) {
		model.addAttribute("winner",  new Winner());
		List<Scholarship> sList =  new ArrayList<Scholarship>();
		sList = scholarshipService.getAllScholarships();
		ModelAndView mav = new ModelAndView("newWinner");
		mav.addObject("scholarshipList", sList);
		
		return mav;
	}
	
//	@Valid
//	BindingResult result
//	@ModelAttribute("winner") Winner winner
	
	//save winner
	
	@RequestMapping(value = "/addWinner", method = RequestMethod.POST)
	public ModelAndView addWinner(@ModelAttribute ("winner") Winner winner, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}

		winnerService.saveWinner(winner);
		ModelAndView model = new ModelAndView("redirect:/scholarship{id}") ;

		return model;
	}
		
//	@RequestMapping(value="/addWinner", method = RequestMethod.POST)
//	public ModelAndView addWinner(@Valid @ModelAttribute("winner") Winner winner, BindingResult result) {
//		
//		if (result.hasErrors()) {
//			System.out.println(result.toString());
//			List<Scholarship> sList =  new ArrayList<Scholarship>();
//			sList = scholarshipService.getAllScholarships();
//			ModelAndView model = new ModelAndView("newWinner");
//			model.addObject("scholarshipList", sList);
//			
//			return model;
//		}
//		System.out.println("winner");
//		System.out.println(winner.toString());
//		winnerService.saveWinner(winner);
//		ModelAndView model = new ModelAndView("redirect:/winnerList");
//
//		return model;
//
//	}
	
	@RequestMapping("/deleteWinner/{id}")
	public ModelAndView deleteWinner(@PathVariable Long id) {
		
		winnerService.deleteWinnerById(id);
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}

	@RequestMapping(value = "/editWinner/{id}", method = RequestMethod.GET)
	public ModelAndView editScholarshipForm(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("editWinner");
		Winner winner = winnerService.getWinnerById(id);
		mav.addObject("headerMessage", "Edit Scholarship Details");
		mav.addObject("winner", winner);
		return mav;
	}
	
	@RequestMapping(value = "/editWinner/{id}", method = RequestMethod.POST)
	public ModelAndView saveEditedWinner(@ModelAttribute Winner winner, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}

		winnerService.saveWinner(winner);
		ModelAndView model = new ModelAndView("redirect:/winnerList");

		return model;
	}
		
	
	
	
}
