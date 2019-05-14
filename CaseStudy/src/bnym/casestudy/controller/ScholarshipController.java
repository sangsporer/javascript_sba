/**
 * 
 */
package bnym.casestudy.controller;

import java.util.Collection;
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

import bnym.casestudy.entity.Scholarship;
import bnym.casestudy.entity.Winner;
import bnym.casestudy.service.ScholarshipService;
import bnym.casestudy.service.WinnerService;

/**
 * @author sang.sporer
 *
 */

@Controller
public class ScholarshipController {

	@Autowired
	ScholarshipService scholarshipService;
	
	@Autowired
	WinnerService winnerService;
	
	
	//admin view all scholarships
	@RequestMapping("/adminScholarshipList")
	public ModelAndView adminScholarshipList() {
		ModelAndView mav = new ModelAndView("adminScholarshipList");
		List<Scholarship> scholarshipList = scholarshipService.getAllScholarships();
		mav.addObject("scholarshipList", scholarshipList);
		return mav;
	}
	
	// add new scholarship
		@RequestMapping("/newScholarship")
		public ModelAndView newScholarship(Model model) {
			model.addAttribute("scholarship", new Scholarship());
			ModelAndView mav = new ModelAndView("newScholarship");
			mav.addObject("types", Scholarship.Type.values());
			return mav;
		}

		// save scholarship
		@RequestMapping(value = "/addScholarship", method = RequestMethod.POST)
		public ModelAndView addScholarship(@Valid @ModelAttribute("scholarship") Scholarship scholarship,
				BindingResult result) {

			if (result.hasErrors()) {
				System.out.println(result.toString());
				ModelAndView model = new ModelAndView("newScholarship");
				return model;
			}

			scholarshipService.saveScholarship(scholarship);
			ModelAndView model = new ModelAndView("redirect:/adminScholarshipList");

			return model;

		}

		@RequestMapping("/deleteScholarship/{id}")
		public ModelAndView deleteScholarship(@PathVariable Long id) {

			scholarshipService.deleteScholarshipById(id);
			ModelAndView mav = new ModelAndView("redirect:/adminScholarshipList");
			return mav;
		}

		@RequestMapping(value = "/editScholarship/{id}", method = RequestMethod.GET)
		public ModelAndView editScholarshipForm(@PathVariable Long id) {
			ModelAndView mav = new ModelAndView("editScholarship");
			Scholarship scholarship = scholarshipService.getScholarshipById(id);
			mav.addObject("types", Scholarship.Type.values());
			mav.addObject("headerMessage", "Edit Scholarship Details");
			mav.addObject("scholarship", scholarship);
			return mav;
		}

		@RequestMapping(value = "/editScholarship/{id}", method = RequestMethod.POST)
		public ModelAndView saveEditedScholarship(@ModelAttribute Scholarship scholarship, 
				BindingResult result) {
			if (result.hasErrors()) {
				System.out.println(result.toString());
				return new ModelAndView("error");
			}

			scholarshipService.saveScholarship(scholarship);
			ModelAndView model = new ModelAndView("redirect:/adminScholarshipList");

			return model;
		}

		// go to admin scholarship page
		@RequestMapping(value = "/adminScholarshipPage/{id}", method = RequestMethod.GET)
		public ModelAndView adminScholarshipPage(@PathVariable Long id) {
			ModelAndView mav = new ModelAndView("adminScholarshipPage");

			Scholarship scholarship = scholarshipService.getScholarshipById(id);
			Collection<Winner> scholarshipWinnerList = scholarship.getWinners();

			mav.addObject("scholarship", scholarship);
			mav.addObject("scholarshipWinnerList", scholarshipWinnerList);
			return mav;
		}

		
//==================================donors and trustee views==============================================================		
	
	// view all scholarships
	@RequestMapping("/scholarshipList")
	public ModelAndView scholarshipList() {
		ModelAndView mav = new ModelAndView("scholarshipList");
		List<Scholarship> scholarshipList = scholarshipService.getAllScholarships();
		mav.addObject("scholarshipList", scholarshipList);
		return mav;
	}

	// go to scholarship page
	@RequestMapping(value = "/scholarshipPage/{id}", method = RequestMethod.GET)
	public ModelAndView gotoScholarshipPage(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("scholarshipPage");

		Scholarship scholarship = scholarshipService.getScholarshipById(id);
		Collection<Winner> scholarshipWinnerList = scholarship.getWinners();

		mav.addObject("scholarship", scholarship);
		mav.addObject("scholarshipWinnerList", scholarshipWinnerList);
		return mav;
	}

	// view all winners
	@RequestMapping(value = "/scholarshipWinnerList/{id}", method = RequestMethod.GET)
	public ModelAndView scholarshipWinnerList(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("scholarshipWinnerList");

		Scholarship scholarship = scholarshipService.getScholarshipById(id);
		Collection<Winner> scholarshipWinnerList = scholarship.getWinners();
//		System.out.println(scholarshipWinnerList.size());
		mav.addObject("scholarship", scholarship);
		mav.addObject("scholarshipWinnerList", scholarshipWinnerList);
		return mav;
	}
	
	

//	// add new scholarship winner
//	@RequestMapping(value = "/newScholarshipWinner/{id}", method = RequestMethod.GET)
//	public ModelAndView newScholarshipWinner(@PathVariable Long id, Model model) {
//		ModelAndView mav = new ModelAndView("newScholarshipWinner");
//		Scholarship scholarship = scholarshipService.getScholarshipById(id);
//
//		mav.addObject("scholarship", scholarship);
//		model.addAttribute("winner", new Winner());
//
//		return mav;
//	}
	
	// get form to add a winner to scholarship
		@RequestMapping(value = "/scholarship/{id}/newWinner", method = RequestMethod.GET)
		public ModelAndView newWinnerToScholarship(Model model) {
			
			model.addAttribute("winner", new Winner());

			return new ModelAndView("newWinner");
		}
	 

//	// save new scholarship winner
//	@RequestMapping(value = "/newScholarshipWinner/{id}", method = RequestMethod.POST)
//	public ModelAndView saveNewScholarshipWinner(@PathVariable Long id, @ModelAttribute Winner winner,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			System.out.println(result.toString());
//			return new ModelAndView("error");
//		}
//		winnerService.saveWinner(winner);
//		Scholarship scholarship = scholarshipService.getScholarshipById(id);
//		scholarship.addWinner(winner);
//		ModelAndView model = new ModelAndView("redirect:/scholarshipList");
//		return model;
//	}
	
	@RequestMapping(value = "/scholarship/{id}/newWinner", method = RequestMethod.POST)
	public ModelAndView saveWinnerToScholarship(@PathVariable Long id, @ModelAttribute ("winner") Winner winner,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}
		
		Scholarship scholarship = scholarshipService.getScholarshipById(id);
		Collection<Winner> winners = scholarship.getWinners();
		winner.setScholarship(scholarship);
		winnerService.saveWinner(winner);
		winners.add(winner);
		scholarshipService.saveScholarship(scholarship);
		return new ModelAndView ("redirect:/scholarshipPage/{id}");
		
	}
	
	

	
}
