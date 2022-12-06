package com.BikkadIt.PhoneBookApplication.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIt.PhoneBookApplication.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactSeviceI {
     @Autowired
	private ContactRepository phoneBookRepository;
	
}
