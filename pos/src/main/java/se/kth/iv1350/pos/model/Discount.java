package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;

/*
The discounts mentioned in alternative 
flow 6a are calculated based on bought
item, number of items bought, total cost for the entire sale, and customer id. A
customer might be eligible for more than one type of discount. Both available
discounts and how to combine them vary over time.
*/

/**
 * This class implements the discount that can be applied to a sale. It is only
 * a rudimentary class and only works a bare minimum.
 * @author Alexander Lundqvist
 */
public class Discount {
    private final String specialItemID = "44444"; // Sausage
    private String customerID;
    private List<GroceryItem> itemsBought;
    private double costOfSale;
    private int amountOfItems;
    
    
    /**
     * Creates an instance of discount
     * @param customerID is used to determine if customer is elegible for discount
     * @param finishedSale information about the sale
     */
    public Discount(String customerID, SaleDTO finishedSale) {
        this.customerID = customerID;
        this.itemsBought = finishedSale.getAddedItems();
        this.costOfSale = finishedSale.getTotalPrice();
    }
    
    public double calculateTotalDiscount() {
        
        double totalDiscount = 0.3;
        return totalDiscount;
    }
    
    private void calculateAmountOfItems() {
        for(int i = 0; i < itemsBought.size(); i++){
            amountOfItems += itemsBought.get(i).getQuantity();  
        }
    }
    
    private void calculateSpecialItem() {
        
    }
     
}
