package se.kth.iv1350.pos.model;

/**
 * This represents the registry in the POS.
 * @author Alexander Lundqvist
 */
public class Registry {
    private double balance;
    
    /**
     * Initializes the registry, should only be done once. The registry has a
     * set starting amount.
     */
    public Registry(){
        this.balance = 200.00;
    }
    
    /**
     * Retrieves the current amount of money in the registry.
     * @return Returns the amount.
     */
    public double getBalance(){
        return this.balance;
    }
    
    /**
     * This updates the registry after a sale.
     * @param moneyTransaction represents money added or subtracted.
     */
    public void updateBalance(double moneyTransaction){
        this.balance = this.balance + moneyTransaction;
        System.out.println("\nThe curent balance in the registry is: " + this.balance + " Euro");
    }
    

}
