/**
 * 
 */
package com.huiyong.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author gangpu
 *
 */
public class DateUtil {
    public static Date getLastMonthDate(Date date) {  
        Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.MONTH, -1);  
        Date dateOfLastMonth = cl.getTime();  
        return dateOfLastMonth;
    } 
    public static void main(String[] args){
    	Date date = new Date();
    	System.out.println(date.toString());
    	System.out.println(getLastMonthDate(date).toString());   	
    }
}
