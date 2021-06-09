package se.kth.iv1350.pos.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class creates and manages the error log file.
 * @author Alexander
 */
public class LogHandler {
    private static final String FILE_NAME = "POS_Exception_log.txt";
    private final PrintWriter exceptionLog;
    
    /**
     * Creates an instance of the handler. Initializes the file writer and creates the file.
     * @throws IOException 
     */
    public LogHandler() throws IOException {
        exceptionLog = new PrintWriter(new FileWriter(FILE_NAME), true);
    }
    
    /**
     * Writes a log describing a thrown exception. Consideres both checked and unchecked exceptions.
     * @param exception The exception that shall be logged.
     */
    public void logException(Exception exception) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("[" + timeStamp() + "]");
        logMessage.append(" Exception was thrown: ");
        logMessage.append("<" + exception.getMessage() + ">");
        //System.out.println(">>> " + logMessage + "\n"); // Prints to console for debugging purpose
        exceptionLog.println(logMessage);
        exception.printStackTrace(exceptionLog);
        exceptionLog.println();
    }
    
    // Creates the timestamp of the thrown exception
    private String timeStamp() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timeStamp = new Date();
        String dateString = formater.format(timeStamp.getTime());
        return dateString;
    }
}