package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;


/**
 * Placeholder class for the real view. It only performs hardcoded funtion calls
 * @author Alexander Lundqvist
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() {
        contr.startSale();
        System.out.println("********************************");
        System.out.println("* A new sale has been started. *");
        System.out.println("********************************");
        
        System.out.println("Following items were added to basket:");
        System.out.println("Another item is added with identifier 33333:");
        contr.addNewItem(66666);


        System.out.println("Another item is added with identifier 66666:");
        contr.addNewItem(66666);
        
        System.out.println("********************************");
        System.out.println("*        Sale has ended.       *");
        System.out.println("********************************");
    }
}
