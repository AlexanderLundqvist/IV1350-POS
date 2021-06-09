package se.kth.iv1350.pos.integration;

/**
 * Handles errors concerning invalid item identifiers.
 * @author Alexander
 */
public class InvalidItemIDException extends Exception{
    private final int invalidItemIdentifier;
    
    /**
     * Creates a new instance of the exception with a message clarifying which item identifier is invalid
     * @param invalidItemIdentifier 
     */
    public InvalidItemIDException(int invalidItemIdentifier) {
        super("Item identifier [" + invalidItemIdentifier + "] does not correspond to an item in inventory");
        this.invalidItemIdentifier = invalidItemIdentifier;
    }
    
    /**
     * Getter for the invalidItemIdentifier
     * @return the invalidItemIdentifier of this instance
     */
    public int getInvalidItemIdentifier() {
        return invalidItemIdentifier;
    }
    
}
