package com.BikkadIt.PhoneBookApplication.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIt.PhoneBookApplication.model.Contact;
import com.BikkadIt.PhoneBookApplication.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactSeviceI {
     @Autowired
	private ContactRepository phoneBookRepository;
//create
	@Override
	public Contact createContact(Contact ct) {
		Contact contact = this.phoneBookRepository.save(ct);
		return contact;
		
	}
	//getAllContact
	@Override
	public List<Contact> getallContact() {
		List<Contact> list = this.phoneBookRepository.findAll();
		return list;
	}
	
	
}
