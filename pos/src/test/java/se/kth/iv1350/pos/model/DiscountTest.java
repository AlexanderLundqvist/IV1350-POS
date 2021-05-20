package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.GroceryItemDTO;


/**
 * This class tests the Discount class and its methods
 * @author Alexander
 */
class DiscountTest {
    String customerID = "12345";
    List<GroceryItem> addedItems = new ArrayList<>();
    Discount discount;
    
    
    @BeforeEach
    void setUp() {
        addedItems.add(new GroceryItem(new GroceryItemDTO(00000, "", 0.00, 0, ""), 10));
        discount = new Discount(customerID, addedItems);
        
    }

    @AfterEach
    void tearDown() {
        addedItems = null;
        discount = null;
    }
    
    @Test
    public void calculateTotalDiscount(){
        double expected = 1;
        double actual = discount.calculateTotalDiscount();
        assertEquals(expected, actual, "Discount was not calculated correctly!");
        
        expected = 0.9;
        actual = discount.calculateTotalDiscount();
        assertEquals(expected, actual, "Discount was not calculated correctly!");
    }

}
