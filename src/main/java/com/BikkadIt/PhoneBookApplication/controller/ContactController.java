package com.BikkadIt.PhoneBookApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIt.PhoneBookApplication.sevice.ContactSeviceI;

@RestController
public class ContactController {
	@Autowired
	private ContactSeviceI phoneBookAppSeviceI;

}
