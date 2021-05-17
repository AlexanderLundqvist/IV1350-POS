package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;

/**
 * Placeholder class for the real view. It only performs hardcoded function calls
 * @author Alexander Lundqvist
 */
public class View {
    private Controller controller;
    private double staticPayment = 100;
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param controller The controller to use for all calls to other layers.
     */
    public View(Controller controller) {
        this.controller = controller;
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution(){
        controller.startSale();
        System.out.println("*************************************************");
        System.out.println("*          A new sale has been started.         *");
        System.out.println("*************************************************");
        
        controller.addNewItem(11111, 2);
        
        controller.addNewItem(22222, 3);
        
        controller.addNewItem(33333, 1);
        
        controller.addNewItem(44444, 1);
        
        controller.addNewItem(55555, 2);
        
        controller.addNewItem(66666, 1);
        
        controller.addNewItem(44444, 5);
        
        //controller.addDiscount(1337);
        
        System.out.println("\nTotal amount to pay is: " + controller.getPaymentDetails());
        
        controller.endSale(staticPayment);
        
        System.out.println("\nChange back is: " + controller.displayChange() + "\n");

        // Empty function, could also print to console
        controller.getReceipt();
        
        System.out.println("\n*************************************************");
        System.out.println("*                 Sale has ended.               *");
        System.out.println("*************************************************");
    }
}
