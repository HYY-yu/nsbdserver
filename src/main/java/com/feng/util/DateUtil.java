package com.feng.util;

import org.apache.http.util.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by feng on 2017/4/21.
 */
public class DateUtil {
    public static Date parse(String strDate) throws ParseException {
        if (TextUtils.isEmpty(strDate)) {
            return null;
        } else {
            SimpleDateFormat e = new SimpleDateFormat(Config.TIME_FORMAT);
            return e.parse(strDate);
        }
    }

    public static String format(Date date) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(Config.TIME_FORMAT);
            returnValue = df.format(date);
        }
        return returnValue;
    }
}
