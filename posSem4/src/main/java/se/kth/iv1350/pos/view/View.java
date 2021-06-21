package se.kth.iv1350.pos.view;

import java.io.IOException;
import java.sql.SQLException;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.controller.OperationFailureException;
import se.kth.iv1350.pos.integration.GroceryItemDTO;
import se.kth.iv1350.pos.integration.InvalidItemIDException;
import se.kth.iv1350.pos.integration.InventoryFailureException;
import se.kth.iv1350.pos.util.TotalRevenueFileOutput;

/**
 * Placeholder class for the real view. It only performs hardcoded function calls
 * @author Alexander Lundqvist
 */
public class View {
    private Controller controller;
    private double staticPayment = 100;
    private ErrorMessageHandler errorMessageHandler;
    
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param controller The controller to use for all calls to other layers.
     * @throws IOException 
     */
    public View(Controller controller) throws IOException {
        this.controller = controller;
        this.errorMessageHandler = new ErrorMessageHandler();
        controller.addObserver(new TotalRevenueView());
        controller.addObserver(new TotalRevenueFileOutput());
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
     * 
     * @throws InvalidItemIDException
     * @throws InventoryFailureException
     * @throws SQLException
     * @throws OperationFailureException 
     */
    public void runFakeExecution() throws InvalidItemIDException, InventoryFailureException, SQLException, OperationFailureException{
        controller.startSale();
        System.out.println("*************************************************");
        System.out.println("*          A new sale has been started.         *");
        System.out.println("*************************************************");
        
        // Add normal item
        fakeAddItem(11111, 2);

        // Simulate DB error
        fakeAddItem(12121, 1);
        
        // Trying to add an item that doesn't exist in the inventory
        fakeAddItem(12345, 1);
        
        if(controller.addDiscount("197001021234") == true) {
            System.out.println("\n>>> Discount added!\n");
        }
        else {
            System.out.println("\n>>> Customer isn't elegible for discount!\n");
        }
                
        System.out.println("\nTotal amount to pay is: " + controller.getPaymentDetails()+ " Euro");

        controller.endSale(staticPayment);

        System.out.println("\nChange back is: " + controller.displayChange() + " Euro\n");

        controller.getReceipt();

        System.out.println("\n*************************************************");
        System.out.println("*                 Sale has ended.               *");
        System.out.println("*************************************************");
        System.out.println();
    }
    
    // Handles exceptions in the view
    private void handleException(String message){
        errorMessageHandler.ShowErrorMessage(message);
    }
    
    private void fakeAddItem(int itemIdentifier, int quantity) {
        try {
            GroceryItemDTO item = controller.addNewItem(itemIdentifier, quantity);
            printItemDescription(item, quantity);
        } catch(InvalidItemIDException | OperationFailureException ex){
            handleException("Could not register item");
        }
    }
    
    private void printItemDescription(GroceryItemDTO item, int quantity) {
        System.out.println(
                "Item: " + item.getItemName() + "\n" +
                "Description: " + item.getItemDescription() + "\n" +        
                "Quantity: " + quantity + " units\n" +
                "Price: " + item.getPrice()*quantity + " Euro\n" +
                "VAT: " + item.getVAT() + "%\n" 
            );
    }
}
