package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the ExternalInventorySystem class
 * @author Alexander
 */
class ExternalInventorySystemTest {
    ExternalInventorySystem inventory;
    
    
    @BeforeEach
    void setUp() {
        inventory = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        inventory = null;
    }
    
    @Test
    public void doesItemExist(){
        int WrongItemIdentifier = 00000;
        boolean expectedCaseOne = false;
        boolean actualCaseOne = inventory.doesItemExist(WrongItemIdentifier);
        assertEquals(expectedCaseOne, actualCaseOne, "Did not find abscense of specified item!");
        
        int itemIdentifier = 11111;
        boolean expectedCaseTwo = true;
        boolean actualCaseTwo = inventory.doesItemExist(itemIdentifier);
        assertEquals(expectedCaseTwo, actualCaseTwo, "Did not find the specified item correctly!");
    }
    
    @Test
    public void fetchItem() throws InvalidItemIDException{
        String expectedItemName = "Sausage";
        String actualItemName = inventory.fetchItem(44444).getItemName();
        assertEquals(expectedItemName, actualItemName, "Found item didn't match!");
        
        expectedItemName = "Nothing";
        actualItemName = inventory.fetchItem(44444).getItemName();
        assertNotEquals(expectedItemName, actualItemName, "Found item did match, which it shouldn't!");
    }
}
