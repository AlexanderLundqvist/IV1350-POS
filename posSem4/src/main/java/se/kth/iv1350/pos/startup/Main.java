package se.kth.iv1350.pos.startup;

import java.io.IOException;
import java.sql.SQLException;
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
    public static void main(String[] args) throws IOException, InvalidItemIDException, InventoryFailureException, SQLException, OperationFailureException{
        try {
            ExternalSystemsHandler externalSystems = new ExternalSystemsHandler();
            Controller controller = new Controller(externalSystems);
            View view = new View(controller);
            view.runFakeExecution();
            view.runFakeExecution(); 
        } catch (IOException ex) {
            System.out.println("The process failed to run.");
            ex.printStackTrace();
        }
        
            
    }
}
