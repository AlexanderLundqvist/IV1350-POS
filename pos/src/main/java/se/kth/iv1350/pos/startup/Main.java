package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.view.*; 
import se.kth.iv1350.pos.integration.*;

/**
 * Contains the main method. Initializes the whole POS application.
 * @author Zander
 */
public class Main {
    /**
     * Main method used to start application
     * @param args The application does not take any command line paramters
     */
    public static void main(String[] args){
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        Controller contr = new Controller(inventorySystem);
        View view = new View(contr);
        view.runFakeExecution();
    }
}
