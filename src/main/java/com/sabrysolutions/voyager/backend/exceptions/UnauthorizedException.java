package com.sabrysolutions.voyager.backend.exceptions;

public class UnauthorizedException extends Exception {


	private String errorKey;
	private String errorDescription;
	
	public UnauthorizedException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UnauthorizedException(String errorKey, String errorDescription) {
		super(errorDescription);
		this.errorKey = errorKey;
		this.errorDescription = errorDescription;
	}
	public UnauthorizedException(String message, Throwable throwable, boolean  enableSuppression, boolean writableStackTrace) {
		super(message, throwable, enableSuppression, writableStackTrace);
		this.errorDescription = message;
		// TODO Auto-generated constructor stub
	}
	public UnauthorizedException(String message, Throwable throwable) {
		super(message, throwable);
		this.errorDescription = message;
		// TODO Auto-generated constructor stub
	}
	public UnauthorizedException(String message) {
		super(message);
		this.errorDescription = message;
		// TODO Auto-generated constructor stub
	}
	public UnauthorizedException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public String getErrorKey() {
		return errorKey;
	}
	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}


}
