package com.zohocrmapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.repositories.LeadRepository;
@Service
public class LeadServiceimpl implements LeadService {
	
	@Autowired
	private LeadRepository leadrepo;

	@Override
	public void saveOneLead(Lead lead) {
		leadrepo.save(lead);
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteLeadById(long id) {
		leadrepo.deleteById(id);
	}

	@Override
	public List<Lead> findAllLeads() {
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}

}
