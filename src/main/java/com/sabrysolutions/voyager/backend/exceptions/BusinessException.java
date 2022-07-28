package com.sabrysolutions.voyager.backend.exceptions;



/**
 * This type of exceptions is throwen when a business logic that prevents us from misusing the application.
 */
public class BusinessException extends VoyagerException {
    @SuppressWarnings("compatibility:-3997456871597405627")
    private static final long serialVersionUID = 1L;

    /**
     * @param message: message to be displayed
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * @param message: message to be displayed
     * @param errorCode: errorCode to be handled
     */
    public BusinessException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @param message: message to be displayed
     * @param errorCode: errorCode to be handled
     * @param cause: cause <i>-root cause exceptions-</i> to be logged
     */
    public BusinessException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
