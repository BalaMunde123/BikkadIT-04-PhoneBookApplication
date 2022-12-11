package com.BikkadIt.PhoneBookApplication.sevice;

import java.util.List;

import com.BikkadIt.PhoneBookApplication.model.Contact;

public interface ContactSeviceI {
	
	//created
	public boolean createContact(Contact ct);
	//getAllData
	public List<Contact> getallContact();
	//getContactById
	public Contact getContactById(Integer contactId);
	//updateContact
	public boolean updateContacts(Contact ct);
	//deleteById
	public boolean deleteContactById(Integer contactId);
	//SoftDeleteById
	public boolean SoftDeleteById(Integer contactId);

}
