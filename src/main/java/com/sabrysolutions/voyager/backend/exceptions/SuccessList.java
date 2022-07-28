package com.sabrysolutions.voyager.backend.exceptions;


import lombok.Data;
import java.util.List;

@Data
public class SuccessList {
    private final int code;
    private final Boolean success;
    private final List message;
    private final String error;
}
