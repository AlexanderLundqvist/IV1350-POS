package se.kth.iv1350.pos.integration;

/**
 * This class represents a customer
 * @author Alexander
 */
public class Customer {
    private String name;
    private String customerID;
    
    /**
     * Creates an instance of customer
     * @param name is the full name of the customer
     * @param customerID is the SSN of the customer
     */
    public Customer(String name, String customerID) {
        this.name = name;
        this.customerID = customerID;
    }
    
    /**
     * Standard getter for retrieving the name of the customer
     * @return the customer name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Standard getter for retrieving the customer ID number
     * @return the customerID
     */
    public String getID() {
        return customerID;
    }
}
