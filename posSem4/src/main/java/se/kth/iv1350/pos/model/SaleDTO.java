package se.kth.iv1350.pos.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO class for simplifying saledata transfer between layers.
 * @author Alexander
 */
public class SaleDTO {
    private LocalTime timeOfSale;
    private LocalDate dateOfSale;
    private List<GroceryItem> addedItems = new ArrayList<>();
    private double totalPrice;
    private double totalVAT;
    private double amountPaid;
    private double change;
    
    /**
     * Creates a new instance of the DTO.
     * @param timeOfSale Time of the sale
     * @param dateOfSale Date of the sale
     * @param addedItems An array of {@link GroceryItem} for all the items of the sale
     * @param totalPrice The total price of the sale, including VAT
     * @param totalVAT The total amount of VAT
     * @param amountPaid What the customer paid
     * @param change What the customer recieved back
     */
    public SaleDTO(LocalTime timeOfSale, LocalDate dateOfSale, 
            List<GroceryItem> addedItems, double totalPrice, 
            double totalVAT, double amountPaid, double change) { 
        this.timeOfSale = timeOfSale;
        this.dateOfSale = dateOfSale;
        this.addedItems = addedItems;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.amountPaid = amountPaid;
        this.change = change; 
    }
    
    /**
     * Standard getter for time of the sale
     * @return the time of the sale
     */
    public LocalTime getTimeOfSale() {
        return timeOfSale;
    }
    
    /**
     * Standard getter for date of the sale
     * @return the date of the sale
     */
    public LocalDate getDateOfSale(){
        return dateOfSale;
    }
    
    /**
     * Standard getter for a list of the items in the sale
     * @return the list of {@link GroceryItem} that were sold
     */
    public List<GroceryItem> getAddedItems() {
        return addedItems;
    }
    
    /**
     * Standard getter for total price of the sale, including VAT
     * @return the total price
     */
    public double getTotalPrice(){
        return totalPrice;
    }
    
    /**
     * Standard getter for total VAT of the sale
     * @return the total VAT
     */
    public double getTotalVAT() {
        return totalVAT;
    }
    
    /**
     * Standard getter for the amount paid by the customer
     * @return the amount paid
     */
    public double getAmountPaid() {
        return amountPaid;
    }
    
    /**
     * Standard getter for change the customer recieved back
     * @return the amount of change
     */
    public double getChange() {
        return change;
    } 
}
