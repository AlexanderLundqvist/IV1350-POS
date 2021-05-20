package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.GroceryItemDTO;

/**
 * Describes a buyable item and quantity of said item 
 * in the grocery store. 
 * @author Alexander Lundqvist
 */
public class GroceryItem {
    private final GroceryItemDTO item;
    private int quantity;
    
    /**
     * Creates an instance of GroceryItem with the caller argument. 
     * @param itemIdentifier tells what the item is.
     * @param quantity tells how many of the item there is
     */
    public GroceryItem(GroceryItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    
    /**
     * Returns the unique item identifier of the item.
     * @return Returns the itemIdentifier.
     */
    public int getItemIdentifier(){
        return item.getItemIdentifier();
    }
    
    /**
     * Returns the name of the item
     * @return Returns a string containing a name
     */
    public String getItemName(){
        return item.getItemName();
    }
    
    /**
     * Returns the quantity of the item.
     * @return Returns the quantity.
     */
    public int getQuantity(){
        return this.quantity;
    }
    
    /**
     * Sets new quantity for the current grocery item.
     * @param newQuantity the desired quantity.
     */
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    
    /**
     * Returns the price of a singular item.
     * @return Returns the price.
     */
    public double getPrice(){
        return item.getPrice();
    }
    
    /**
     * Calculates and provides the total price for the item instance since it
     * can hold duplicate items.
     * @return Returns the price for all of the same item. 
     */
    public double getTotalPrice(){
        return item.getPrice()*quantity;
    }
    
    /**
     * Returns the VAT of the item.
     * @return Returns the vatRate.
     */
    public double getVAT(){
        return item.getVAT();
    }
    
    /**
     * Returns the unique description of the item.
     * @return Returns the itemDescription.
     */
    public String getItemDescription(){
        return item.getItemDescription();
    }
    
}
