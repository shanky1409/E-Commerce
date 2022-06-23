package com.practice.spring.ecom.customer.services.mails;

public interface MailService <T> {
	public void sendMail(T object, String operation);
}
