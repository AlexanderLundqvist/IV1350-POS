package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This represents the process of a sale.
 * @author Alexander Lundqvist
 */
public class Sale {
    private LocalTime timeOfSale;
    private LocalDate dateOfSale;
    private Receipt receipt;
    private List<GroceryItem> addedItems = new ArrayList<>();
    private Discount discount;
    private double runningTotal;
    private double totalVAT;
    
    
    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale() {
        this.timeOfSale = LocalTime.now();
        this.dateOfSale = LocalDate.now();
        this.receipt = new Receipt(this);
        this.runningTotal = 0;
        this.totalVAT = 0;
    }
    
    public void updateRunningTotal(){
        
    }
    
    public void updateTotalVAT(){
        
    }
    
    privat double calculateVAT(int itemIdentifier){
        
    }
    
    public double getRunningTotal(){
        return this.runningTotal;
    }
    
    public double getTotalVAT(){
        return this.totalVAT;
    }
}
