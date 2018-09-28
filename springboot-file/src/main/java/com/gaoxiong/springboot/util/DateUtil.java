package com.gaoxiong.springboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaoxiong
 * @ClassName DateUtil
 * @Description TODO
 * @date 2018/9/23 15:22
 */
public class DateUtil {

    public static Date getDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
          return   dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
