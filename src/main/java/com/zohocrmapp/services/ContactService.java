package com.zohocrmapp.services;

import java.util.List;

import com.zohocrmapp.entities.Contact;

public interface ContactService {
	public void saveContact(Contact contact);

	public List<Contact> listAllContacts();

	public Contact findContactById(long id);
}
