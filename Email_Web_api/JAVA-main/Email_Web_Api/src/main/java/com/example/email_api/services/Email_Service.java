package com.example.email_api.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class Email_Service {

	public boolean sendEmail(String message, String to, String subject) {
		boolean f = false;
		
		System.out.println("To "+to);
		String from = "tinkukaushik9821@gmail.com";
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
	//	System.out.println("properties :"+" "+properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("tinkukaushik9821@gmail.com", "Nilesh@1234");
			}

		});
		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);
		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setText(message);
			
			Transport.send(m);
			
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}

}
