package com.BikkadIt.PhoneBookApplication.sevice;

import java.util.List;

import com.BikkadIt.PhoneBookApplication.model.Contact;

public interface ContactSeviceI {
	
	//created
	public Contact createContact(Contact ct);
	//getAllData
	public List<Contact> getallContact();

}
