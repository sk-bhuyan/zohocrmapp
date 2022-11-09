package com.zohocrmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Billing;
import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.services.BillingService;
import com.zohocrmapp.services.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactservice;
	
	@Autowired
	private BillingService billingservice;
	
	@RequestMapping("/generateBill")
	public String viewBillingPage(@RequestParam("id")long id, Model model) {
		Contact contact = contactservice.findContactById(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
	}
	
	@PostMapping("/saveBill")
	public String saveBill(@ModelAttribute("bill")Billing bill) {
		billingservice.saveOneBill(bill);
		return "list_all_contacts";
	}
}
