package com.zohocrmapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Billing;
import com.zohocrmapp.repositories.BillingRepository;

@Service
public class BillingServiceimpl implements BillingService {
	
	@Autowired
	private BillingRepository billrepo;

	@Override
	public void saveOneBill(Billing bill) {
		billrepo.save(bill);
	}

}
