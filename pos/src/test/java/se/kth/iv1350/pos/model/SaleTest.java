package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import se.kth.iv1350.pos.integration.ExternalInventorySystem;
import se.kth.iv1350.pos.integration.Printer;

/**
 * This class tests the Sale class
 * @author Alexander
 */
class SaleTest {
    Sale sale;
    Printer printer;
    
    @BeforeEach
    void setUp() {
        printer = new Printer();
        sale = new Sale(printer);
    }

    @AfterEach
    void tearDown() {
        printer = null;
        sale = null;
    }
    
    //@Test
    
}
