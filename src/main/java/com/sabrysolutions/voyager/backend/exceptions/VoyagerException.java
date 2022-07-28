package com.sabrysolutions.voyager.backend.exceptions;

import java.util.List;

/**
 * This exceptions is the parent of all exceptions.
 */
public class VoyagerException extends Throwable {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorDescription;
	private List<String[]> paramsList;

	
	public List<String[]> getParamsList() {
		return paramsList;
	}

	public void setParamsList(List<String[]> paramsList) {
		this.paramsList = paramsList;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	// Constructors
	public VoyagerException(String errorCode) {
		this.errorCode = errorCode;
	}

	public VoyagerException(String message, String errorCode) {
		super(message);
		this.errorDescription = message;
		this.errorCode = errorCode;
	}

	public VoyagerException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}