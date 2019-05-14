/**
 * 
 */
package bnym.casestudy.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
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
import bnym.casestudy.entity.Transaction;
import bnym.casestudy.entity.Winner;
import bnym.casestudy.service.ScholarshipService;
import bnym.casestudy.service.TransactionService;

/**
 * @author sang.sporer
 *
 */

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	ScholarshipService scholarshipService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(sdf, false));
	}

	// admin view of all transactions
	@RequestMapping(value = "/adminTransactionList/{id}", method = RequestMethod.GET)
	public ModelAndView adminTransactionList(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("adminTransactionList");
		Scholarship scholarship = scholarshipService.getScholarshipById(id);
		Collection<Transaction> transactionList = scholarship.getTransactions();
		mav.addObject("scholarship", scholarship);
		mav.addObject("transactionList", transactionList);
		return mav;
	}

	// get form to add new transaction to scholarship
	@RequestMapping(value = "/scholarship/{id}/newTransaction", method = RequestMethod.GET)
	public ModelAndView newWinnerToScholarship(Model model) {
		
		ModelAndView mav = new ModelAndView("newTransaction");
		model.addAttribute("transaction", new Transaction());
		mav.addObject("types", Transaction.Type.values());

		return mav;
	}

	//add transaction to scholarship
	@RequestMapping(value = "/scholarship/{id}/newTransaction", method = RequestMethod.POST)
	public ModelAndView saveWinnerToScholarship(@PathVariable Long id, @ModelAttribute ("transaction") Transaction transaction,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}
		
		Scholarship scholarship = scholarshipService.getScholarshipById(id);
		Collection<Transaction> transactions = scholarship.getTransactions();
		transaction.setScholarship(scholarship);
		transactionService.saveTransaction(transaction);
		transactions.add(transaction);
		scholarshipService.saveScholarship(scholarship);
		return new ModelAndView ("redirect:/scholarshipPage/{id}");
		
	}
	
	
//=================views not linked to scholarship======================
	// view all transactions
	@RequestMapping("/transactionList")
	public ModelAndView transactionList() {
		ModelAndView mav = new ModelAndView("transactionList");
		List<Transaction> transactionList = transactionService.getAllTransactions();
		mav.addObject("transactionList", transactionList);
		return mav;
	}

	// add new transactions
	@RequestMapping("/newTransaction")
	public ModelAndView newTransaction(Model model) {
		model.addAttribute("transaction", new Transaction());
		ModelAndView mav = new ModelAndView("newTransaction");
		mav.addObject("types", Transaction.Type.values());
		return mav;
	}

	// save transaction
	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public ModelAndView addTransaction(@Valid @ModelAttribute("transaction") Transaction transaction,
			BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result.toString());
			ModelAndView model = new ModelAndView("newTransaction");
			return model;
		}

		transactionService.saveTransaction(transaction);
		ModelAndView model = new ModelAndView("redirect:/transactionList");

		return model;

	}

	@RequestMapping("/deleteTransaction/{id}")
	public ModelAndView deleteTransaction(@PathVariable Long id) {

		transactionService.deleteTransactionById(id);
		ModelAndView mav = new ModelAndView("redirect:/transactionList");
		return mav;
	}

	@RequestMapping(value = "/editTransaction/{id}", method = RequestMethod.GET)
	public ModelAndView editTransactionForm(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("editTransaction");
		Transaction transaction = transactionService.getTransactionById(id);
		mav.addObject("types", Transaction.Type.values());
		mav.addObject("headerMessage", "Edit Transaction Details");
		mav.addObject("transaction", transaction);
		return mav;
	}

	@RequestMapping(value = "/editTransaction/{id}", method = RequestMethod.POST)
	public ModelAndView saveEditedTransaction(@ModelAttribute Transaction transaction, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}

		transactionService.saveTransaction(transaction);
		ModelAndView model = new ModelAndView("redirect:/transactionList");

		return model;
	}

}
