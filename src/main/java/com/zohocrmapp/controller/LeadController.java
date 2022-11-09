package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@Autowired
	private ContactService contactservice;
	
	// http://localhost:8080/zohocrmapp/viewCreateLeadPage
	@RequestMapping("/viewCreateLeadPage")	//we can use @GetMapping() also but will only work as get() method. can't be use as post() method.
	public String viewCreateLeadPage() {
		return "create_new_lead";
	}
	
	@PostMapping("/savelead")
	public String saveLead(@ModelAttribute("lead")Lead lead, Model model) {
		leadservice.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	@PostMapping("/convertlead")
	public String convertLead(@RequestParam("id")long id, Model model) {
		Lead lead=leadservice.findLeadById(id);
		
		Contact contact=new Contact();
		
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactservice.saveContact(contact);
		
		leadservice.deleteLeadById(id);
		
		List<Contact> contacts = contactservice.listAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_all_contacts";
	}
	
	// http://localhost:8080/zohocrmapp/listLeads
	@RequestMapping("/listLeads")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadservice.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_all";
	}
	
	@RequestMapping("/LeadInfo")
	public String leadInfo(@RequestParam("id")long id,Model model) {
		Lead lead = leadservice.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
}