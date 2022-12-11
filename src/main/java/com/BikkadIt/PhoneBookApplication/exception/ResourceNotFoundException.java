package com.BikkadIt.PhoneBookApplication.exception;

public class ResourceNotFoundException extends RuntimeException{
	String filedname;
	int contactId;
	public ResourceNotFoundException(String filedname, int contactId) {
		super();
		this.filedname = filedname;
		this.contactId = contactId;
	}
	
	

}
