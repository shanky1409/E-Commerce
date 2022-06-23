package com.practice.spring.ecom.customer.services.mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.spring.ecom.customer.models.Customer;
import com.practice.spring.ecom.customer.models.Mail;
import com.practice.spring.ecom.customer.utils.EComUtils;


@Service
@Async
public class MailServiceCustomerImpl implements MailService<Customer> {

	private String url = "http://localhost:8082/mail";
	private HttpHeaders httpHeaders;
	private final RestTemplate restTemplate;
	
	@Autowired
	public MailServiceCustomerImpl(HttpHeaders httpHeaders, RestTemplate restTemplate) {
		this.httpHeaders = httpHeaders;
		this.restTemplate= restTemplate;
	}


	@Override
	public void sendMail(Customer customer, String operation) {
		String to= customer.getEmail();
		String subject = getSubject(operation);
		String messageBody= getMessageBody(customer, operation);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		Mail mail = new Mail(to,subject,messageBody);
		HttpEntity<Mail> entity = new HttpEntity<Mail>(mail, httpHeaders);
		String reponse= this.restTemplate.postForObject(url, entity, String.class);
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


	private String getMessageBody(Customer customer, String operation) {
		
		String messageBody="";
		if(operation.equals(EComUtils.NEW)) {
			messageBody+="Dear "+customer.getFirstName()+
					"<br><br> Your account is created for E-Com application.<br>"
					+ "Please confirm your details."
					+ "<br>Name: "+customer.getFirstName()+" "+customer.getLastName()
					+ "<br>Email "+customer.getEmail()
					+ "<br>Phone Number: "+ customer.getPhoneNumber()
					+ "<br>Address: "+ customer.getAddress()
					+ "<br><br>Regards,<br>E-Com";
		}
		else if(operation.equals(EComUtils.UPDATE)) {
			messageBody+="Dear "+customer.getFirstName()+
					"<br><br> Your E-Com account has been updated successfully.<br>"
					+ "Please confirm your details."
					+ "<br>Name: "+customer.getFirstName()+" "+customer.getLastName()
					+ "<br>Email "+customer.getEmail()
					+ "<br>Phone Number: "+ customer.getPhoneNumber()
					+ "<br>Address: "+ customer.getAddress()
					+ "<br><br>Regards,<br>E-Com";
		}
		else if(operation.equals(EComUtils.DELETE)) {
			messageBody+="Dear "+customer.getFirstName()+
					"<br><br> Your E-Com account has been removed.<br>"
					+ "<br><br>Regards,<br>E-Com";
		}
		else {
			throw new RuntimeException("Invalid operation performed");
		}
		return messageBody;
	}

}
