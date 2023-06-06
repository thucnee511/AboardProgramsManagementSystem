/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DateModifier {

    public static String toDateString(Date date, String format) {
        if (format == null) {
            format = "dd/MM/yyyy";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public Date toDate(String date, String format) throws ParseException {
        if (format == null) {
            format = "dd/MM/yyyy";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date ret = sdf.parse(date);
        return ret;
    }
    
    public static boolean inRange(Date start , Date end , Date current){
        if (end == null) return start.equals(current) || start.before(current) ;
        else if (start == null) return end.equals(current) || end.after(current) ;
        else{
            boolean afterStart = start.equals(current) || start.before(current) ;
            boolean beforeEnd = end.equals(current) || end.after(current) ;
            return afterStart && beforeEnd ;
        }
    }
}
