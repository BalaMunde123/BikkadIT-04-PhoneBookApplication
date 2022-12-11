package com.BikkadIt.PhoneBookApplication.sevice;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIt.PhoneBookApplication.exception.ResourceNotFoundException;
import com.BikkadIt.PhoneBookApplication.model.Contact;
import com.BikkadIt.PhoneBookApplication.props.AppConst;
import com.BikkadIt.PhoneBookApplication.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactSeviceI {
     @Autowired
	private ContactRepository contactRepository;
//create
	@Override
	public boolean createContact(Contact ct) {
		Contact contact = this.contactRepository.save(ct);
		if(contact!=null) {
			return true;
		}else {
			return false;
		}
		
	}
	//getAllContact
	@Override
	public List<Contact> getallContact() {
		List<Contact> contacts = this.contactRepository.findAll();
		List<Contact> list = contacts.stream().filter(contact->contact.getActiveSwitch()==AppConst.Y).collect(Collectors.toList());
		return list;
	}
	//getById
	@Override
	public Contact getContactById(Integer contactId) {
		Contact contact = this.contactRepository.findById(contactId).orElseThrow(()->new ResourceNotFoundException("Contact",contactId));
		
		return contact;
	}
	
	//updateData
	@Override
	public boolean updateContacts(Contact ct) {
		Contact contact = this.contactRepository.save(ct);
		if(contact!=null) {
			return true;
		}else {
			return false;
		}
		
	}
	//detelebyId
	@Override
	public boolean deleteContactById(Integer contactId) {
		boolean exists = this.contactRepository.existsById(contactId);
		if(exists) {
			this.contactRepository.deleteById(contactId);
			return true;
		}else {
			return false;
		}
	
	}
	//SoftDeleteById
	@Override
	public boolean SoftDeleteById(Integer contactId) {
		 Contact contact = this.contactRepository.findById(contactId).orElseThrow(()->new ResourceNotFoundException("Contact", contactId));
		if(contact!=null) {
			contact.setActiveSwitch('N');
			this.contactRepository.save(contact);
			return true;
		}else {
		return false;
		}
	}
	
	
}
