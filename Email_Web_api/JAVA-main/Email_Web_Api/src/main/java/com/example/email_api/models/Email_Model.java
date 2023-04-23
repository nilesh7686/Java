package com.example.email_api.models;

public class Email_Model {
	
	private String to;
	private String subject;
	private String message;
	public Email_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Email_Model(String to, String subject, String message) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Email_Model [to=" + to + ", subject=" + subject + ", message=" + message + "]";
	}
	
	
}
