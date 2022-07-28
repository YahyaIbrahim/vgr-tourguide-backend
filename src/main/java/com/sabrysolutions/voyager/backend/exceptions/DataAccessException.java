package com.sabrysolutions.voyager.backend.exceptions;

public class DataAccessException extends VoyagerException {

	/**
	 * @param message:   message to be displayed
	 * @param errorCode: errorCode to be handled
	 * @param cause:     cause <i>-root cause exceptions-</i> to be logged
	 */
	public DataAccessException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message:   message to be displayed
	 * @param errorCode: errorCode to be handled
	 */
	public DataAccessException(String message, String errorCode) {
		super(message, errorCode);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message: message to be displayed default errorCode is "DB_Exception"
	 */
	public DataAccessException(String errorCode) {
		super("DB_Exception");
		// TODO Auto-generated constructor stub
	}

}
