package com.revature.model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.revature.util.EmailUtil;

public class Email implements Runnable {
	private String emailSubject;
	private String emailBody;
	private String emailAddress;
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Email(String emailSubject, String emailBody, String emailAddress) {

		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
		this.emailAddress = emailAddress;
	}
	@Override
	public void run() {
		final String fromEmail = "ewindowshopper123@gmail.com"; 
		final String password = "jamr1234"; 
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "587"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable", "true"); 

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		EmailUtil.sendEmail(session, emailAddress,emailSubject,emailBody);
		
	}

	

}
