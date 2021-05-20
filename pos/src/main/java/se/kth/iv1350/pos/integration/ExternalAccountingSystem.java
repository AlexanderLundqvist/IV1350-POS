package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.SaleDTO;

/**
 * This class represent the accounting system. It is not implemented as it is
 * not needed for showing the functionality of the POS as accounting is not
 * relevant for the user.
 * @author Zander
 */
public class ExternalAccountingSystem {
    
    /**
     * Initializes the accounting system. Should only be called once. 
     */
    public ExternalAccountingSystem(){
        
    }
    
    /**
     * Updates the accounting system. Not implemented, only tells that there has
     * been an update to the system.
     * @param saleInfo tells how the accounting system should be updated. 
     */
    public void updateAccounting(SaleDTO saleInfo){
        System.out.println("\n>>> Accounting system has been updated.");
    }
}
