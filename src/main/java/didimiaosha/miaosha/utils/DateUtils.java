package didimiaosha.miaosha.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static Long getDiff(Date d1,Date d2){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            long diff = d1.getTime() - d2.getTime();
            return diff;
        }catch (Exception e){
            throw e;
        }

    }
}
