package se.kth.iv1350.pos.controller;

/**
 * Exception thrown for generic errors in controller
 * @author Alexander
 */
public class OperationFailureException extends Exception{
    /**
     * 
     * @param message description about the exception
     * @param cause the cause of the exception
     */
    public OperationFailureException(String message, Exception cause) {
        super(message, cause);
    }
}
