package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.List;

/**
 * Represents a receipt. Used as proof of payment for the customer
 * @author Alexander Lundqvist
 */
public class Receipt {
    private SaleDTO saleInfo;
    
    /**
     * 
     * @param saleInfo determines what shall be stored in the receipt.
     */
    public Receipt(SaleDTO saleInfo){
        this.saleInfo = saleInfo;
    }
    
    public SaleDTO getSaleInfo(){
        return saleInfo;
    }
}
