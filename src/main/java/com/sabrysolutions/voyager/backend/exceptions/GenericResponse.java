package com.sabrysolutions.voyager.backend.exceptions;

import lombok.Data;

@Data
public class GenericResponse {
    private int code;
    private String message;
    private String error;

    public GenericResponse(int code,String message) {
        super();
        this.code =code;
        this.message = message;
    }

    public GenericResponse(int code,String message, String error) {
        super();
        this.code =code;
        this.message = message;
        this.error = error;
    }
}