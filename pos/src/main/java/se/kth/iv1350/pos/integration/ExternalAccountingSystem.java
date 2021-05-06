package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Sale;

/**
 * This class represent the accounting system. It is not implemented as it is
 * not needed for showing the functionality of the POS as accounting is not
 * relevant for the user.
 * @author Zander
 */
public class ExternalAccountingSystem {
    
    /**
     * Initializes the accounting system. Should only be called once. 
     * Only tells that the accounting system has started.
     */
    public ExternalAccountingSystem(){
        System.out.println("Accounting system initialized.");
    }
    
    /**
     * Updates the accounting system. Not implemented, only tells that there has
     * been an update to the system.
     * @param finishedSale tells how the accounting system should be updated. 
     */
    public void updateAccounting(Sale finishedSale){
        System.out.println("Accounting system has been updated.");
    }
}
