package se.kth.iv1350.pos.model;

/**
 * This represents the registry in the POS.
 * @author Alexander Lundqvist
 */
public class Registry {
    private double amount;
    
    /**
     * Initializes the registry, should only be done once. The registry has a
     * set starting amount.
     */
    public Registry(){
        this.amount = 200.00;
    }
    
    /**
     * Retrieves the current amount of money in the registry.
     * @return Returns the amount.
     */
    public double getAmount(){
        return this.amount;
    }
    
    /**
     * This updates the registry after a sale.
     * @param moneyTransaction represents money added or subtracted.
     */
    public void updateAmount(double moneyTransaction){
        this.amount = this.amount + moneyTransaction;
    }
    
}
