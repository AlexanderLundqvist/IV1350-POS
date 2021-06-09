package se.kth.iv1350.pos.model;

/**
 * Observer pattern for keeping track of updates to total revenue
 * @author Alexander
 */
public interface SaleObserver {
    
    /**
     * Method for updating the observer
     * @param runningTotal 
     */
    void newRunningTotal(double runningTotal);
}
