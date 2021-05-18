package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.GroceryItem;
import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.pos.model.SaleDTO;

/**
 * Represents the inventory system for the grocery store. It only contains a
 * hardcoded inventory for now.
 * @author Alexander Lundqvist
 */
public class ExternalInventorySystem {
    private List<GroceryItem> inventory = new ArrayList<>();
    
    /**
     * Creates a placeholder inventory.
     */
    public ExternalInventorySystem(){
            inventory.add(new GroceryItem(new GroceryItemDTO(11111, "Bread", 2.50, 6, "Freshly baked bread."), 11));
            inventory.add(new GroceryItem(new GroceryItemDTO(22222, "Milk", 3.50, 6, "Fat-free dairy milk."), 22));
            inventory.add(new GroceryItem(new GroceryItemDTO(33333, "Cheese", 7.75, 12, "Aged cheese from france."), 33));
            inventory.add(new GroceryItem(new GroceryItemDTO(44444, "Sausage", 5.25, 12, "Italian sausage."), 44));
            inventory.add(new GroceryItem(new GroceryItemDTO(55555, "Beer", 13.37, 24, "A sixpack of premium beer."), 55));        
    }
    
    /**
     * Updates the inventory. Not implemented for now.
     */
    public void UpdateInventory(SaleDTO saleinfo){
        
    }
    
    /**
     * Checks the current inventory if a certain item exists.
     * @param itemIdentifier is the desired item to check
     * @return Returns true or false depending on outcome
     */
    public boolean doesItemExist(int itemIdentifier){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemIdentifier() == itemIdentifier)
                return true;
        }
        return false;
    }
    
    /**
     * Finds item from inventory from input identifier, returns a properly
     * created grocery item that can be used.
     * @param itemIdentifier determines what item to fetch
     * @return Returns a DTO for a grocery item
     */
    public GroceryItemDTO fetchItem(int itemIdentifier){
        GroceryItemDTO wantedItem;
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemIdentifier() == itemIdentifier){
                String name = inventory.get(i).getItemName();
                double price = inventory.get(i).getPrice();
                int vat = inventory.get(i).getVAT();
                String description = inventory.get(i).getItemDescription();
                wantedItem = new GroceryItemDTO(itemIdentifier, name, price, vat, description);
                return wantedItem;
            }  
        }
        return null;
    }
}
