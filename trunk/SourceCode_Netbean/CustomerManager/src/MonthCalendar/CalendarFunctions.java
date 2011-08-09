/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MonthCalendar;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sy tuan
 */
public class CalendarFunctions {
    public static Date dayBefore(Date date){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();

    }
    public static Date dayBeforeSomeDay(Date dt , int xday){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        
        calendar.add(Calendar.DATE, 0  - xday);
        return calendar.getTime();
    }

    public static Date dayAfter(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();

    }
    public static Date monthBefore(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }
    public static Date monthAfter(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }
    public static int dayBeginMonth(Calendar cal){
       
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

}
