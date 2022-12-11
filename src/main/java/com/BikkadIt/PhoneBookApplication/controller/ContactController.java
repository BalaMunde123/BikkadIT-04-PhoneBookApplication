package com.BikkadIt.PhoneBookApplication.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIt.PhoneBookApplication.model.Contact;
import com.BikkadIt.PhoneBookApplication.props.AppConst;
import com.BikkadIt.PhoneBookApplication.props.AppProps;
import com.BikkadIt.PhoneBookApplication.sevice.ContactSeviceI;

@RestController
public class ContactController {
	@Autowired
	private ContactSeviceI contactSeviceI;

	@Autowired
	private AppProps appProps;

	/**
	 * @author BAlasaheb
	 * @apiNote create Contact List in db
	 * 
	 * @param ct
	 * @return
	 */
	@PostMapping(value = "/creatContact", consumes = "application/json")
	public ResponseEntity<String> createdContact(@RequestBody Contact ct) {

		Map<String, String> messages = appProps.getMessages();
		
		boolean contact = this.contactSeviceI.createContact(ct);
		if (contact) {
			String msg = messages.get(AppConst.SAVE_SUCCESS);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			String fail = messages.get(AppConst.SAVE_FAIL);
			return new ResponseEntity<String>(fail, HttpStatus.CREATED);

		}
	}
	/** 
	 * @author Balasaheb
	 * @apiNote get all Contact
	 * 
	 * @return
	 */	
	@GetMapping(value = "/getAllContact", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact() {
		List<Contact> list = this.contactSeviceI.getallContact();
		List<Contact> list2 = list.stream().filter((contact) -> contact.getActiveSwitch() == 'Y')
				.collect(Collectors.toList());
		return new ResponseEntity<List<Contact>>(list2, HttpStatus.OK);

	}
	
	/**
	 * @author Balasaheb
	 * @apiNote get contact by id
	 *  
	 * @param contactId
	 * @return
	 */
	@GetMapping(value = "/getContactDataByID/{contactId}")
	public ResponseEntity<Contact> getContactDataByID(@PathVariable Integer contactId) {
		Contact contactById = this.contactSeviceI.getContactById(contactId);

		return new ResponseEntity<Contact>(contactById, HttpStatus.OK);

	}

	/**
	 *  @author Balasaheb
	 *  @apiNote Update Contact Data
	 * @param ct
	 * @return
	 */
	@PutMapping("/updateContact")
	public ResponseEntity<String> updateContact(@RequestBody Contact ct) {
		Map<String, String> messages = appProps.getMessages();
		boolean contacts = this.contactSeviceI.updateContacts(ct);
		if (contacts) {
			String msg = messages.get(AppConst.S_UPDATE);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			String mgs = messages.get(AppConst.F_UPDATE);
			return new ResponseEntity<String>(mgs, HttpStatus.OK);
		}
	}

	/**
	 *  @author Balasaheb
	 *  @apiNote ContactDeleted By Id
	 *  
	 * @param contactId
	 * @return
	 */
	@DeleteMapping(value = "/deleteById/{contactId}")
	public ResponseEntity<String> contactdeleteById(@PathVariable Integer contactId) {
		Map<String, String> messages = appProps.getMessages();
		boolean deleteContactById = this.contactSeviceI.deleteContactById(contactId);
		if (deleteContactById) {
			String msg = messages.get(AppConst.DELETED);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Deleted Successfully", HttpStatus.OK);
		}

	}

	/**
	 * @author Balasaheb
	 * @apiNote SoftDeleteById
	 * @param contactId
	 * @return
	 */
	@DeleteMapping(value = "/softDeleteById/{contactId}")
	public ResponseEntity<String> softDeletById(@PathVariable Integer contactId) {
		boolean deleteById = this.contactSeviceI.SoftDeleteById(contactId);
		if (deleteById) {
			String msg = "Id Deleted Succefully!!";
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Id Not Deleted", HttpStatus.OK);
		}

	}

}
