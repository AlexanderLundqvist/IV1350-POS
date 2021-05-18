package se.kth.iv1350.pos.model;

/**
 * Represents a receipt. Used as proof of payment for the customer
 * @author Alexander Lundqvist
 */
public class Receipt {
    private static String storeName = "SuperDuperMart";
    private static String storeAddress = "4 Privet Drive";
    private SaleDTO saleInfo;
    
    /**
     * Creating an instance of a receipt
     * @param saleInfo determines what shall be stored in the receipt.
     */
    public Receipt(SaleDTO saleInfo){
        this.saleInfo = saleInfo;
    }
    
    /**
     * Getter for the information DTO in the receipt
     * @return the DTO
     */
    public SaleDTO getSaleInfo(){
        return saleInfo;
    }
    
    /**
     * Getter for the name of the store
     * @return the name of the store
     */
    public String getName() {
        return storeName;
    }
    
    /**
     * Getter for the store adress
     * @return the adress of the store
     */
    public String getAddress() {
        return storeAddress;
    }
}
