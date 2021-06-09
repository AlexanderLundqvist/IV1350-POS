package se.kth.iv1350.pos.view;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * The class contains functions to produce error messages
 * @author Alexander
 */
public class ErrorMessageHandler {

    /**
     * Constructs the error message that is sent to the consolöe
     * @param message is the message that is printed to console
     */
    void ShowErrorMessage(String message){
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("[" + timeStamp() + "]");
        errorMessage.append(" ERROR: ");
        errorMessage.append("<" + message + ">");
        System.out.println(">>> " + errorMessage + "\n");
    }
    
    private String timeStamp() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timeStamp = new Date();
        String dateString = formater.format(timeStamp.getTime());
        return dateString;
    }

}