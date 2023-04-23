package com.example.email_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.email_api.models.Email_Model;
import com.example.email_api.services.Email_Service;

@RestController
public class Email_Controller {

	@Autowired
	Email_Service service;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendMail(@RequestBody Email_Model email){
		
		boolean result = service.sendEmail(email.getMessage(),email.getTo(),email.getSubject());
				if(result) {
					return ResponseEntity.ok("mail send sucessfully");
				}
				else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email not send");
				}
		
	}

}
