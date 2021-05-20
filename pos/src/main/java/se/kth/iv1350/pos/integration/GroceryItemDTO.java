package se.kth.iv1350.pos.integration;

/**
 * Describes a singular item in the grocery store.
 * @author Alexander Lundqvist
 */
public class GroceryItemDTO {
    private final int itemIdentifier;
    private final String itemName;
    private final double price;
    private final double vatRate;
    private final String itemDescription;
    
    /**
     * Creates an instance of the item.
     * 
     * @param itemIdentifier the unique identifier for the item
     * @param itemName the name of the item
     * @param price is the total price for the item
     * @param vatRate tells what the VAT is for the item
     * @param itemDescription describes item
     */
    public GroceryItemDTO(int itemIdentifier, String itemName,
            double price, double vatRate, String itemDescription){
        this.itemIdentifier = itemIdentifier;
        this.itemName = itemName;
        this.price = price;
        this.vatRate = vatRate;
        this.itemDescription = itemDescription;
    }
    
    /**
     * Retrieves the unique item identifier number
     * @return the itemIdentifier of the item
     */
    public int getItemIdentifier(){
        return itemIdentifier;
    } 
    
    /**
     * Retrieves the name of the item
     * @return the itemName of the item
     */
    public String getItemName(){
        return itemName;
    }
    
    /**
     * Retrieves the price of the item.
     * @return Returns the price of the item
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Retrieves the VAT of the item.
     * @return Returns the vatRate of the item
     */
    public double getVAT(){
        return vatRate;
    }
    
    /**
     * Retrieves the unique description of the item.
     * @return Returns the itemDescription of the item
     */
    public String getItemDescription(){
        return itemDescription;
    }
}
