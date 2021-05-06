package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;

/**
 * This class represents a printer. The printer is not implemented in this
 * program and the purpose of this class is only to show that the printer exists.
 * @author Alexander Lundqvist
 */
public class Printer {
    
    /**
     * Should be initialized onced. Only states that the printer has turned on.
     */
    public Printer(){
        System.out.println("Printer has started.");
    }
    
    /**
     * This function is supposed to print out a receipt from the printer.
     * @param receipt is produced from ending the sale.
     */
    public void printReceipt(Receipt receipt){
        System.out.println("Receipt has been printed");
    }
}
