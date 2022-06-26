package com.test.spring.mailservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.mailservice.mailer.IMailer;
import com.test.spring.mailservice.models.Mail;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	private IMailer mailer;

	@Autowired
	public MailController(IMailer smtpMailer) {
		this.mailer= smtpMailer;
	}

	@RequestMapping( method = RequestMethod.POST)
	public String mail(@RequestBody Mail mail) {
		return mailer.send(mail);
	}
	
}
