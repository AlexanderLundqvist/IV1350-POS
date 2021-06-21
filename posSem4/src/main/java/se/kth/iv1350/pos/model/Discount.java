package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the discount that can be applied to a sale. It is only
 * a rudimentary class and only works a bare minimum.
 * @author Alexander Lundqvist
 */
public class Discount {
    private final String specialItemID = "44444"; // Sausage
    private String customerID;
    private List<GroceryItem> itemsBought;
    private int amountOfItems;
    
    
    /**
     * Creates an instance of discount
     * @param customerID is used to determine if customer is elegible for discount
     * @param finishedSale information about the sale
     */
    public Discount(String customerID, List<GroceryItem> addedItems) {
        this.customerID = customerID;
        this.itemsBought = addedItems;
    }
    
    /**
     * Calculates the total discount that the customer can get. Only considers 
     * the amount of items bought for now.
     * @return the total discount in percent
     */
    public double calculateTotalDiscount() {
        double totalDiscount = 1;
        calculateAmountOfItems();
        if(amountOfItems >= 10) {
            totalDiscount = 0.9;
        }
        return totalDiscount;
    }
    
    private void calculateAmountOfItems() {
        for(int i = 0; i < itemsBought.size(); i++){
            amountOfItems += itemsBought.get(i).getQuantity();  
        }
    }
     
}
