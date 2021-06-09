package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing that InventoryFailureException is correctly thrown
 * @author Alexander
 */
class InventoryFailureExceptionTest {
    ExternalInventorySystem inventory;
    
    
    @BeforeEach
    void setUp() {
        inventory = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        inventory = null;
    }
    
    /**
     * Testing that execption is not thrown in normal execution
     */
    @Test
    public void testNormalExecution() {
        int itemIdentifier = 11111;
        Assertions.assertDoesNotThrow(() -> inventory.fetchItem(itemIdentifier));
    }
    
    /**
     * Testing that the exception is thrown during intended condition
     */
    @Test
    public void testThrowable() {
        int itemIdentifier = 12121;
        Throwable exception = Assertions.assertThrows(InventoryFailureException.class, () -> {
            inventory.fetchItem(itemIdentifier);
        });
        Assertions.assertTrue(exception.getMessage().equals("Could not connect to database"));
    }
}
