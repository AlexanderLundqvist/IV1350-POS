package se.kth.iv1350.pos.util;

import java.text.DecimalFormat;

/**
 * This class represents an amount of money. Currency is not considered. 
 * @author Alexander
 */
public class Amount {
    private final double amount;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    /**
     * Creates a new instance of amount ant initializes it to zero.
     */
    public Amount() {
        this.amount = 0;
    }
    
    /**
     * Creates a new instance of amount with the specified amount.
     * @param amount is the specified amount the new instance should contain.
     */
    public Amount(double amount) {
        this.amount = amount;
    }
    
    /**
     * Adds two amounts
     * @param other is another amount to be added
     * @return a new instance of amount with the sum
     */
    public Amount add(Amount other) {
        return new Amount(amount + other.amount);
    }
    
    /**
     * Subtracts one amount from another
     * @param other is another amount to be subtracted
     * @return a new instance of amount with the differance
     */
    public Amount sub(Amount other) {
        return new Amount(amount - other.amount);
    }
    
    /**
     * Multiplies two amounts
     * @param other
     * @return a new instance of amount with multiplied value
     */
    public Amount multiply(Amount other) {
        return new Amount(amount * other.amount);
    }
    
    /**
     * Outputs readable string for the amount
     * @return a readable string value of amount
     */
    @Override
    public String toString () {
	String number = "";
        number += decimalFormat.format(amount);           
	return number;
    }
}
