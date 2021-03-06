package com.hclproject.TrainTicket.Utils;

/**
 * 
 * 
 * 
 * Date Utils Class used to
 * Read a date string and parse/convert to a date
 * read a date and format/convert to a string
 * 
 * 
 * */

/**
 * 
 * @author Harish
 * 
 * 
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	 // The date formatter
    // - dd:   day in month (number)
    // - MM:   month in year (number)
    // - yyyy: year
    //
   
    //
    //
	
	
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    /**
	 * 
	 * @param dateStr the string type date
	 * 
	 * */
    
    // read a date string and parse/convert to a date
    public static Date parseDate(String dateStr) throws ParseException {
        Date theDate = formatter.parse(dateStr);
        
        return theDate;        
    }
    
    /**
     * 
     * @param theDate the Date type variable 
     * 
     * */
    
    // read a date and format/convert to a string
    public static String formatDate(Date theDate) {
        
        String result = null;
        
        if (theDate != null) {
            result = formatter.format(theDate);
        }
        
        return result;
    }
}
