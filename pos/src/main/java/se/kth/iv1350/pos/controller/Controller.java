package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;

/**
 *
 * @author Alexander Lundqvist
 */
public class Controller {
    private ExternalInventorySystem inventory;
    private ExternalAccountingSystem accounting;
    private Sale sale;
    private SaleDTO saleInfo;
    private Registry registry;
    private Printer printer;
    
    /**
     * Initializes the controler with the external systems. Only done once.
     * @param externalSystems contains the systems
     */
    public Controller(ExternalSystemsHandler externalSystems){
        this.inventory = externalSystems.getInventory();
        this.accounting = externalSystems.getAccounting();
        this.registry = new Registry();
        this.printer = new Printer();
    }
    
    /**
     * Starts a new sale. This method must be called before doing anything else during a sale. 
     */
    public void startSale() {
        sale = new Sale(printer);
    }
    
    /**
     * Used to add an item to the current sale by fetching it from the inventory
     * 
     * @param itemIdentifier the unique identifying number for the item
     * @param quantity specifies how many of the item
     */
    public void addNewItem(int itemIdentifier, int quantity) {
       if (inventory.doesItemExist(itemIdentifier) == true){
            sale.addItem(inventory.fetchItem(itemIdentifier), quantity);
            System.out.println(
                    "Item: " + inventory.fetchItem(itemIdentifier).getItemName() + "\n" +
                    "Description: " + inventory.fetchItem(itemIdentifier).getItemDescription() + "\n" +        
                    "Quantity: " + quantity + " units\n" +
                    "Price: " + inventory.fetchItem(itemIdentifier).getPrice()*quantity + " Euro\n" +
                    "VAT: " + inventory.fetchItem(itemIdentifier).getVAT() + "%\n" 
            );
        }
        else{
            System.out.println("Item not found!\n");
        }      
    }
    
    public double getPaymentDetails() {
         return sale.getRunningTotal();
    }

    
    public void endSale(double amountPaid) {
        saleInfo = sale.endSale(amountPaid);
        updateExternalSystems(saleInfo);
    }
   
    public double displayChange() {
        return saleInfo.getChange();
    }
    
    private void updateExternalSystems(SaleDTO saleInfo) {
        inventory.UpdateInventory(saleInfo);
        accounting.updateAccounting(saleInfo);
    }
    
    public void getReceipt() {
        sale.createReceipt();
    }
}
