package com.BikkadIt.PhoneBookApplication.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="CONTACT_DTLS")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	@Column(name = "CONTACT_NAME")    
	private String contactName;
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_ACTIVE_SWITCH")  
	private Character activeSwitch;

	@Column(name = "CONTACT_CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(name = "CONTACT_UPDATED_DATE",insertable =false)
	@UpdateTimestamp
	private LocalDate updateDate;

}
