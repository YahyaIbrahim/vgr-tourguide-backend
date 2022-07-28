package com.sabrysolutions.voyager.backend.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {
	private String errorCode;
	private String errorDescription;

	public ErrorResponseDto(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
}