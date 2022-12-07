package com.BikkadIt.PhoneBookApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIt.PhoneBookApplication.model.Contact;
import com.BikkadIt.PhoneBookApplication.sevice.ContactSeviceI;

@RestController
public class ContactController {
	@Autowired
	private ContactSeviceI phoneBookAppSeviceI;
	
	//creted
	@PostMapping(value ="/creatContact",consumes ="application/json",produces ="application/json")
	public ResponseEntity<Contact> createdContact(@RequestBody Contact ct){
		Contact contact = this.phoneBookAppSeviceI.createContact(ct);
		
		return new ResponseEntity<Contact>(contact,HttpStatus.CREATED);
		
			 
		}
		//getAllData
	@GetMapping(value ="/getAllContact",produces ="application/json")
	public ResponseEntity<List<Contact>> getAllContact(){
		List<Contact> list = this.phoneBookAppSeviceI.getallContact();
		
		return new ResponseEntity<List<Contact>>(list,HttpStatus.OK);
		
	}
		
		
	}


