package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a database handler for storing and retrieving information about
 * customers elegible for discount
 * @author Alexander
 */
public class CustomerDatabaseSystem {
    private List<Customer> elegibleCustomers = new ArrayList<>();
    
    /**
     * Creates a fake database with customers elegible for discount
     */
    public CustomerDatabaseSystem() {
        elegibleCustomers.add(new Customer("Test Testerson", "197001021234"));
    }
    
    /**
     * Checks if the customer ID exists in the database
     * @param customerID is the ID that needs to be checked
     * @return a boolean depending on outcome
     */
    public boolean doesCustomerExist(String customerID){
        for(int i = 0; i < elegibleCustomers.size(); i++){
            if(elegibleCustomers.get(i).getID() == customerID)
                return true;
        }
        return false;
    }
}
