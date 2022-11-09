package com.zohocrmapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceimpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailsender;

	@Override
	public void simpleMailMessage(String to, String sub, String emailBody) {
		
		SimpleMailMessage mailmessage=new SimpleMailMessage();
		mailmessage.setTo(to);
		mailmessage.setSubject(sub);
		mailmessage.setText(emailBody);
		
		mailsender.send(mailmessage);
	}

}
