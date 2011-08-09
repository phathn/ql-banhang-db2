package Helpers;

import Persistences.*;
import java.awt.Font;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;

public class GlobalVariables {

    public static Font g_font = new Font("Microsoft Sans Serif", 0, 11);
    public static Users CurrentUser;
    public static Hashtable<String, Customers> gCustomers;
    public static Hashtable<String, Scheduling> gSchedulings;
    public static Hashtable<String, Salepromotion> gSalePromotions;
    public static Scheduling MinSchedule;
    public static Hashtable<String, String> gPromotionCodes;

    public static int PROMOTION_EXPIRE_DAY;
    public static String MAIL_SERVER_USER;
    public static String MAIL_SERVER_PASSWORD;

    public static Scheduling GetMinSchedule() {
        ArrayList<Scheduling> lstItem = new ArrayList<Scheduling>();
        for (Iterator it = gSchedulings.values().iterator(); it.hasNext();) {
            lstItem.add((Scheduling) it.next());
        }
        if (lstItem.size() == 0) {
            return null;
        }
        Scheduling min = lstItem.get(0);
        for (int i = 1; i < lstItem.size(); i++) {
            if (CompareSchedule(lstItem.get(i), min)) {
                min = lstItem.get(i);
            }
        }
        return min;
    }

    public static boolean CompareSchedule(Scheduling s1, Scheduling s2) {
        if (s1.getDateschedule().compareTo(s2.getDateschedule()) > 0) {
            return false;
        } else if (s1.getDateschedule().compareTo(s2.getDateschedule()) < 0) {
            return true;
        } else {
            if (s1.getTime() > s2.getTime()) {
                return false;
            } else if (s1.getTime() < s2.getTime()) {
                return true;
            } else {
                if (s1.getMinute() > s2.getMinute()) {
                    return false;
                }
                return true;
            }
        }
    }

    public static boolean AlarmTime(Scheduling sche) {
        if (sche == null) {
            return false;
        }
        Date today = new Date();
        if (DateFormat.getInstance().format(today).split(" ")[0].equals(DateFormat.getInstance().format(sche.getDateschedule()).split(" ")[0])) {
            if (today.getHours() == sche.getTime() && today.getMinutes() == sche.getMinute()) {
                return true;
            }
        }
        return false;
    }

    public static String generateRandomCharacters() {
        double randomNumber;
        double randomNumberSetup;
        char randomCharacter;
        String randomString = "";

        for (int i = 0; i < 10; i++) {
            randomNumber = Math.random();
            randomNumberSetup = (randomNumber * 26 + 'a');
            randomCharacter = (char) randomNumberSetup;
            randomString += randomCharacter;
        }
        return randomString;
    }
}
