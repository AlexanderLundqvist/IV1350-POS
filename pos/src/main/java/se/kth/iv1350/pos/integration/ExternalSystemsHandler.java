package se.kth.iv1350.pos.integration;

/**
 * Creates the external systems for the POS and provides access to respective
 * system.
 * @author Alexander
 */
public class ExternalSystemsHandler {
    private ExternalInventorySystem inventory;
    private ExternalAccountingSystem accounting;
    private CustomerDatabaseSystem customerDatabase;
    
    /**
     * Initializes the external systems
     */
    public ExternalSystemsHandler() {
        this.inventory = new ExternalInventorySystem();
        this.accounting = new ExternalAccountingSystem();
        this.customerDatabase = new CustomerDatabaseSystem();
    }
    
    /**
     * Standard getter for the external inventory system
     * @return the external inventory
     */
    public ExternalInventorySystem getInventory() {
        return inventory;
    }
    
    /**
     * Standard getter for the external accounting system
     * @return the external accounting system
     */
    public ExternalAccountingSystem getAccounting() {
        return accounting;
    }
    
    /**
     * Standard getter for retrieving the customer database
     * @return the customerDatabase
     */
    public CustomerDatabaseSystem getCustomerDatabase() {
        return customerDatabase;
    }
}
