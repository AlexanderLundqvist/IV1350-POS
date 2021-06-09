package se.kth.iv1350.pos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.util.LogHandler;
import se.kth.iv1350.pos.view.TotalRevenueView;

/**
 * Controller class that handles function calls between view and model.
 * @author Alexander Lundqvist
 */
public class Controller {
    private ExternalInventorySystem inventory;
    private ExternalAccountingSystem accounting;
    private CustomerDatabaseSystem customerDatabase;
    private Sale sale;
    private SaleDTO saleInfo;
    private Registry registry;
    private Printer printer;
    private LogHandler logger;
    private List<SaleObserver> observers = new ArrayList<>();
    
    /**
     * Initializes the controler with the external systems. Only done once.
     * @param externalSystems contains the systems
     */
    public Controller(ExternalSystemsHandler externalSystems) throws IOException{
        this.inventory = externalSystems.getInventory();
        this.accounting = externalSystems.getAccounting();
        this.customerDatabase = externalSystems.getCustomerDatabase();
        this.registry = new Registry();
        this.printer = new Printer();
        this.logger = new LogHandler();
    }
    
    /**
     * Starts a new sale. This method must be called before doing anything else during a sale. 
     */
    public void startSale() {
        sale = new Sale(printer);
        sale.addObservers(observers);
    }
    
    /**
     * Used to add an item to the current sale by fetching it from the inventory
     * 
     * @param itemIdentifier the unique identifying number for the item
     * @param quantity specifies how many of the item
     */ 
    public void addNewItem(int itemIdentifier, int quantity) throws InvalidItemIDException, OperationFailureException {
        try {
            GroceryItemDTO item = inventory.fetchItem(itemIdentifier);
            sale.addItem(item, quantity);
            System.out.println(
                "Item: " + inventory.fetchItem(itemIdentifier).getItemName() + "\n" +
                "Description: " + inventory.fetchItem(itemIdentifier).getItemDescription() + "\n" +        
                "Quantity: " + quantity + " units\n" +
                "Price: " + inventory.fetchItem(itemIdentifier).getPrice()*quantity + " Euro\n" +
                "VAT: " + inventory.fetchItem(itemIdentifier).getVAT() + "%\n" 
            );
        } catch(InvalidItemIDException | InventoryFailureException ex) {
            logger.logException(ex); // Logs both types for now
            throw new OperationFailureException("Could not register the item", ex);
        } 
    }
    
    /**
     * Used to retrieve the total value of the current sale
     * @return the current running total of the sale
     */
    public double getPaymentDetails() {
         return sale.getRunningTotal();
    }

    /**
     * Ends the current sale
     * @param amountPaid is the amount paid by the customer
     */
    public void endSale(double amountPaid) {
        saleInfo = sale.endSale(amountPaid);
        updateExternalSystems(saleInfo);
    }
    
    /**
     * Used to retrieve the amount of change after payment
     * @return the change back to the customer
     */
    public double displayChange() {
        return saleInfo.getChange();
    }
    
    private void updateExternalSystems(SaleDTO saleInfo) {
        inventory.UpdateInventory(saleInfo);
        accounting.updateAccounting(saleInfo);
        registry.updateBalance(saleInfo.getAmountPaid() - saleInfo.getChange());
    }
    
    /**
     * Passes on the request of creating a physical receipt
     */
    public void getReceipt() {
        sale.createReceipt();
    }
    
    /**
     * Passes on discount request to the current sale
     * @param customerID is the customer SSN
     */
    public void addDiscount(String customerID) {
        if (customerDatabase.doesCustomerExist(customerID) == true){
            sale.addDiscount(customerID);
            System.out.println("\n>>> Discount added!\n");
        }
        else{
            System.out.println("\n>>> Customer isn't elegible for discount!\n");
        } 
    }
    
    /**
     * Adds a new observer to the observer list
     * @param observer is the observer to be added
     */
    public void addObserver(SaleObserver observer){
        observers.add(observer);
    }
    
}
