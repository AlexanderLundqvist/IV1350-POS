package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This represents the process of a sale and the required actions.
 * @author Alexander Lundqvist
 */
public class Sale {
    private LocalTime timeOfSale;
    private LocalDate dateOfSale;
    private Receipt receipt;
    private Printer printer;
    private List<GroceryItem> addedItems = new ArrayList<>();
    private Discount discount;
    private double runningTotal;
    private double totalVAT;
    private double change;
    private SaleDTO saleInfo;
    
    
    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(Printer printer) {
        this.timeOfSale = LocalTime.now();
        this.dateOfSale = LocalDate.now();
        this.runningTotal = 0;
        this.totalVAT = 0;
        this.printer = printer;
    }
    
    /**
     * Adding an {@link GroceryItemDTO} to the sale and also calling for price update.
     * @param item The item to be added
     * @param quantity how many of said item
     */
    public void addItem(GroceryItemDTO item, int quantity){
        if(checkExistingItem(item, quantity) == true){
           return;
        }    
        else {
            addedItems.add(new GroceryItem(item, quantity));
            updateRunningTotal(item, quantity);
            updateTotalVAT(item, quantity);
        }
    }
    
    private boolean checkExistingItem(GroceryItemDTO item, int quantity) {
        for (int i = 0; i < addedItems.size(); i++){
            if (addedItems.get(i).getItemIdentifier() == item.getItemIdentifier()){
                addedItems.get(i).setQuantity(quantity + addedItems.get(i).getQuantity());
                updateRunningTotal(item, quantity);
                updateTotalVAT(item, quantity);
                return true;
            }
        }
        return false;
    }
    
    private void updateRunningTotal(GroceryItemDTO item, int quantity) {
        runningTotal += (item.getPrice()*quantity)*((item.getVAT()/100)+1);
    }
    
    
    private void updateTotalVAT(GroceryItemDTO item, int quantity) {
        totalVAT += (item.getPrice()*quantity)*(item.getVAT()/100);
    }
    
    /**
     * Standard getter for retrieveing the running total of the sale
     * @return the running total
     */
    public double getRunningTotal() {
        return this.runningTotal;
    }
    
    /**
     * Standard getter for the total VAT of the sale
     * @return the total VAT
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
   
    
    private void updateChange(double amountPaid){
        change = (double) Math.round((amountPaid - getRunningTotal()) * 100) / 100;
    }
    
    public void addDiscount(String customerId) {
        
    }
    
    /**
     * Ends the current sale
     * @param amountPaid is the amount that the customer paid
     * @return the {@link SaleDTO}
     */
    public SaleDTO endSale(double amountPaid) {
        updateChange(amountPaid);
        saleInfo = new SaleDTO(timeOfSale, dateOfSale, addedItems, 
                runningTotal, totalVAT, amountPaid, change);
        return saleInfo;
    }
    
    /**
     * Creates a receipt and also sends it to the printer
     */
    public void createReceipt(){
        receipt = new Receipt(saleInfo);
        printer.printReceipt(receipt);
    }
}
