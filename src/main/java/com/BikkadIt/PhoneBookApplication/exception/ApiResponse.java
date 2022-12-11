package com.BikkadIt.PhoneBookApplication.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ApiResponse {
   
	String Message;
	boolean Success; 
	

}
