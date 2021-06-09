package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.SaleObserver;

/**
 * The class represents to total amount paid by customer since the POS started
 * @author Alexander
 */
public class TotalRevenueView implements SaleObserver{
    private double totalAmountPaid;
    
    /**
     * Creates a new instance. Should only be called once at program start
     * @param initialAmount is the starting amount
     */
    public TotalRevenueView() {
        totalAmountPaid = 0.0;
    }
    
    @Override
    public void newRunningTotal(double amountPaid) {
        totalAmountPaid += amountPaid;
        formatOutput(totalAmountPaid);
    }
    
    private void formatOutput(double amount) {
        System.out.println("==================================================");
        System.out.println(" Total revenue since the POS started");
        System.out.println(" Amount: " + amount);
        System.out.println("==================================================");
    } 
}
