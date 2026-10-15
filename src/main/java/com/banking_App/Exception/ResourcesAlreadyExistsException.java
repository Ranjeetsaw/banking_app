package com.banking_App.Exception;

public class ResourcesAlreadyExistsException  extends RuntimeException {
	
	public ResourcesAlreadyExistsException(String fieldName) {
		super(fieldName +" already exist !!!");
	}

}
