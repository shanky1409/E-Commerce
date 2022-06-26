package com.practice.spring.ecom.customer.services.mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.spring.ecom.customer.models.Mail;
import com.practice.spring.ecom.customer.utils.EComUtils;


@Service
@Async
public class MailServiceCustomerImpl implements MailService {

	private HttpHeaders httpHeaders;
	private final RestTemplate restTemplate;
	@Value("{ecom.mailservice.url}")
	private String mailServiceUrl;
	
	@Autowired
	public MailServiceCustomerImpl(HttpHeaders httpHeaders, RestTemplate restTemplate) {
		this.httpHeaders = httpHeaders;
		this.restTemplate= restTemplate;
	}


	@Override
	public void sendMail(String to, String operation) {
		String subject = getSubject(operation);
		String messageBody= getMessageBody(to, operation);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		Mail mail = new Mail(to,subject,messageBody);
		HttpEntity<Mail> entity = new HttpEntity<Mail>(mail, httpHeaders);
		System.out.println(mail);
		String reponse= this.restTemplate.postForObject(mailServiceUrl, entity, String.class);
		System.out.println(reponse);
	}


	private String getSubject(String operation) {
		String subject="";
		if(operation.equals(EComUtils.NEW)) {
			subject+="Customer created successfully!!";
		}else if(operation.equals(EComUtils.UPDATE)) {
			subject+="Customer updated successfully!!";
		}else if(operation.equals(EComUtils.DELETE)) {
			subject+="Your account has been deleted successfully!!";
		}else {
			throw new RuntimeException("Invalid operation performed");
		}
		return subject;
	}


	private String getMessageBody(String email, String operation) {
		
		String messageBody="";
		if(operation.equals(EComUtils.NEW)) {
			messageBody+="Dear "+email+
					",<br><br> Your account is created for E-Com application.<br>"
					+ "<br><br>Regards,<br>E-Com";
		}
		else if(operation.equals(EComUtils.UPDATE)) {
			messageBody+="Dear "+email+
					",<br><br> Your E-Com account has been updated successfully.<br>"
					+ "<br><br>Regards,<br>E-Com";
		}
		else if(operation.equals(EComUtils.DELETE)) {
			messageBody+="Dear "+email+
					"<br><br> Your E-Com account has been removed.<br>"
					+ "<br><br>Regards,<br>E-Com";
		}
		else {
			throw new RuntimeException("Invalid operation performed");
		}
		return messageBody;
	}

}
