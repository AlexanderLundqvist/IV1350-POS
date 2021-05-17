package se.kth.iv1350.pos.integration;

/**
 * Creates the external systems for the POS and provides access to respective
 * system.
 * @author Alexander
 */
public class ExternalSystemsHandler {
    private ExternalInventorySystem inventory;
    private ExternalAccountingSystem accounting;
    
    /**
     * Initializes the external systems
     */
    public ExternalSystemsHandler() {
        this.inventory = new ExternalInventorySystem();
        this.accounting = new ExternalAccountingSystem();
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
}
