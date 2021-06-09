package se.kth.iv1350.pos.integration;

/**
 * Represents errors in the inventory. Only used for "database" errors
 * @author Alexander
 */
public class InventoryFailureException extends RuntimeException{
    /**
     * Creates a new instance representing the exception thrown.
     * @param message Describing the error.
     */
    public InventoryFailureException(String message) {
        super(message);
    }
}
