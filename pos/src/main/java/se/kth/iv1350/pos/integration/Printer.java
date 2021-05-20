package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.List;

/**
 * This class represents a printer. The printer is not implemented in this
 * program and the purpose of this class is only to show that the printer exists.
 * @author Alexander Lundqvist
 */
public class Printer {
    
    /**
     * Should be initialized onced. Only states that the printer has turned on.
     */
    public Printer(){
        
    }
    
    /**
     * This function is supposed to print out a receipt from the printer.
     * @param receipt is produced from ending the sale.
     */
    public void printReceipt(Receipt receipt){
        System.out.println("\n>>> Printing receipt...");
        List<GroceryItem> addedItems = receipt.getSaleInfo().getAddedItems();
        SaleDTO saleInfo = receipt.getSaleInfo();
        try {
            File newFile = new File("receipt.txt");
            if (newFile.createNewFile()) {
              System.out.println(">>> File created: " + newFile.getName());
            } else {
              System.out.println(">>> File already exists.");
            }
            FileWriter receiptWriter = new FileWriter("receipt.txt");
            receiptWriter.write("*************************************************\n");
            receiptWriter.write("**************** " + receipt.getName() + " *****************\n");
            receiptWriter.write("* " + receipt.getAddress() + "                                *\n");
            receiptWriter.write("* Receipt nr. 0001                              *\n");
            receiptWriter.write("*************************************************\n");
            for(int i = 0; i < addedItems.size(); i++)  {
                receiptWriter.write("\nItem: " + addedItems.get(i).getItemName() + "\n");
                receiptWriter.write("  Quantity: " + addedItems.get(i).getQuantity() + " units\n");
                receiptWriter.write("  Price per item: " + addedItems.get(i).getPrice() + " Euro\n");
                receiptWriter.write("  Total price: " + addedItems.get(i).getPrice()*addedItems.get(i).getQuantity() + " Euro\n");
                receiptWriter.write("  VAT: " + addedItems.get(i).getVAT() + "%\n");
                receiptWriter.write("  Description: " + addedItems.get(i).getItemDescription() + "\n");
            }
            receiptWriter.write("\n> Total cost of sale: " + saleInfo.getTotalPrice() + " Euro\n");
            receiptWriter.write("> Total VAT of sale: " + saleInfo.getTotalVAT() + " Euro\n");
            receiptWriter.write("> Amount paid: " + saleInfo.getAmountPaid() + " Euro\n");
            receiptWriter.write("> Change back: " + saleInfo.getChange() + " Euro\n");
            receiptWriter.write("*************************************************\n");
            receiptWriter.write("*************************************************");
            receiptWriter.close();
            System.out.println(">>> Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println(">>> An error occurred.");
            e.printStackTrace();
        }
        System.out.println("\n>>> Receipt has been printed\n");
    }
}
