package com.sabrysolutions.voyager.backend.exceptions;



/**
 * This type of exceptions is throwen when technical problems that prevent us from using the application.
 */
public class SystemException extends VoyagerException  {
    @SuppressWarnings("compatibility:45123368081062303")
    private static final long serialVersionUID = 1L;

    /**
     * @param message: message to be displayed
     * default errorCode is "SYSTEM_Exception"
     */
    public SystemException(String message) {
        super(message, "SYSTEM_Exception");
    }
    
    /**
     * @param message: message to be displayed
     * @param errorCode: errorCode to be handled
     */
    public SystemException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @param message: message to be displayed
     * @param errorCode: errorCode to be handled
     * @param cause: cause <i>-root cause exceptions-</i> to be logged
     */
    public SystemException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
