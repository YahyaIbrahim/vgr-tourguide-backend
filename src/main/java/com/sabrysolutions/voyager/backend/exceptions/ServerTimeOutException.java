package com.sabrysolutions.voyager.backend.exceptions;

public class ServerTimeOutException extends Exception {
	
	private String errorCode;
	private String errorDescription;

	
	public ServerTimeOutException() {
		// TODO Auto-generated constructor stub
	}

	
	public ServerTimeOutException(String errorCode, String errorDescription) {
		super(errorDescription);
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	/**
	 * @param message
	 */
	public ServerTimeOutException(String message) {
		super(message);
		this.setErrorDescription(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ServerTimeOutException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServerTimeOutException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ServerTimeOutException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	
}

