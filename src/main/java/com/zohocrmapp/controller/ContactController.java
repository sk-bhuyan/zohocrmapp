package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactservice;
	
	// http://localhost:8080/zohocrmapp/listContacts
	@RequestMapping("/listContacts")
	public String listAllContacts(Model model) {
		List<Contact> contacts = contactservice.listAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_all_contacts";
	}
	
	@RequestMapping("/ContactInfo")
	public String contactInfo(@RequestParam("id")long id,Model model) {
		Contact contact = contactservice.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
}
