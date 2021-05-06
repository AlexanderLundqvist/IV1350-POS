package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;

/**
 *
 * @author Alexander Lundqvist
 */
public class Controller {
    private Sale sale;
    private ExternalInventorySystem inventory;
    private Printer printer;
    
    
    
    public Controller(ExternalInventorySystem inventorySystem){
        this.inventory = inventorySystem;
    }
    
    /**
     * Starts a new sale. This method must be called before doing anything else during a sale. 
     */
    public void startSale() {
        sale = new Sale();
    }
    
    public void addNewItem(int itemIdentifier, int quantity){
        
    }
    
    public void endSale() {
        
    }
    
    public void printReceipt(){
        
    }
}
