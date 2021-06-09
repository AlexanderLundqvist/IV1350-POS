package se.kth.iv1350.pos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.kth.iv1350.pos.model.SaleObserver;

/**
 * Prints the total revenue of all purchases since the program started
 * @author Alexander
 */
public class TotalRevenueFileOutput implements SaleObserver{
    private static final String FILE_NAME = "Revenue_log.txt";
    private PrintWriter fileOutput;
    private double totalAmountPaid;

    /**
     * Creates a new instance
     */
    public TotalRevenueFileOutput(){
        totalAmountPaid = 0.0;
        
    }
    
    @Override
    public void newRunningTotal(double amountPaid) {
        totalAmountPaid += amountPaid;
        try {
            printToFile(totalAmountPaid);
        } catch (IOException ex) {
            Logger.getLogger(TotalRevenueFileOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printToFile(double amountPaid) throws IOException {
        fileOutput = new PrintWriter(new FileWriter(FILE_NAME), true);
        fileOutput.println("==================================================");
        fileOutput.println("Time: " + LocalDateTime.now());
        fileOutput.println("The total revenue is: " + amountPaid + " Euro");
        fileOutput.println();
        fileOutput.println("==================================================");
    }
}
