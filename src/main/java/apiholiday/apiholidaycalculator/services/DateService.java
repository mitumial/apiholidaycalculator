package apiholiday.apiholidaycalculator.services;

import java.util.Calendar;
import java.util.Date;

public class DateService {
    public static Date getHolyWeek(int year){
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19*a + 24) % 30;

        int days = d + (2*b + 4*c + 6*d + 5) % 7;
        int day = 15 + days;
        int month = 3;

        return new Date(year - 1900, month-1, day);
    }

    public static Date incrementDays(Date date, int days){
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.add(Calendar.DATE, days);
        return cld.getTime();
    }

    public static Date getNextMonday(Date date){
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        int weekDay = cld.get(Calendar.DAY_OF_WEEK);
        if (weekDay != Calendar.MONDAY){
            if (weekDay < 2) {
                date = incrementDays(date, 1);
            } else{
                date = incrementDays(date, 9-weekDay);
            }
            
        }
        
        return date;
    }
}
