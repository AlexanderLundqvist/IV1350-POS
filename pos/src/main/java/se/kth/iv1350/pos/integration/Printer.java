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
        System.out.println("\nPrinting receipt...");
        List<GroceryItem> addedItems = receipt.getSaleInfo().getAddedItems();
        SaleDTO saleInfo = receipt.getSaleInfo();
        try {
            File newFile = new File("receipt.txt");
            if (newFile.createNewFile()) {
              System.out.println("File created: " + newFile.getName());
            } else {
              System.out.println("File already exists.");
            }
            FileWriter receiptWriter = new FileWriter("receipt.txt");
            receiptWriter.write("Receipt nr. 0001\n");
            for(int i = 0; i < addedItems.size(); i++)  {
                receiptWriter.write("\nItem: " + addedItems.get(i).getItemName() + "\n");
                receiptWriter.write("Quantity: " + addedItems.get(i).getQuantity() + "\n");
                receiptWriter.write("Price: " + addedItems.get(i).getPrice() + "\n");
                receiptWriter.write("VAT: " + addedItems.get(i).getVAT() + "\n");
                receiptWriter.write("Description: " + addedItems.get(i).getItemDescription() + "\n");
            }
            receiptWriter.write("\nTotal cost of sale: " + saleInfo.getTotalPrice() + "\n");
            receiptWriter.write("Total VAT of sale: " + saleInfo.getTotalVAT() + "\n");
            receiptWriter.write("Amount paid: " + saleInfo.getAmountPaid() + "\n");
            receiptWriter.write("Change back: " + saleInfo.getChange() + "\n");
            receiptWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("\nReceipt has been printed\n");
    }
}
