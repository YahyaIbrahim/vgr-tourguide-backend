package com.sabrysolutions.voyager.backend.exceptions;


import lombok.Data;

@Data
public class SuccessString {
    private final int code;
    private final String message;
    private final String error;
}
