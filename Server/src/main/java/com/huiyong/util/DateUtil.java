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
}
