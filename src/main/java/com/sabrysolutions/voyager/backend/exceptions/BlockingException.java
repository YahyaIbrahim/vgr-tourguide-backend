package com.sabrysolutions.voyager.backend.exceptions;

public class BlockingException extends VoyagerException {

	public BlockingException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public BlockingException(String message, String errorCode) {
		super(message, errorCode);
		// TODO Auto-generated constructor stub
	}

	public BlockingException(String errorCode) {
		super(errorCode);
		// TODO Auto-generated constructor stub
	}

}
