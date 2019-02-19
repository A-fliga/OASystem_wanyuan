package org.oasystem_wanyuan.utils;

import android.text.format.DateFormat;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by www on 2017/11/17.
 */

public class InitDateUtil {
    //初始化日期
    public static void initDate(TextView dateTV) {
        long sysTime = System.currentTimeMillis();
        CharSequence sysTimeStr = DateFormat.format("yyyy年MM月dd日", sysTime);
        dateTV.setText(sysTimeStr);
    }

    //初始化日期
    public static CharSequence getDate(long time) {
        return DateFormat.format("yyyy年MM月dd日", time);
    }

    //初始化时钟
    public static CharSequence getTime(long time) {
        return DateFormat.format("HH:mm", time);
    }

    //初始化日期
    public static CharSequence getDate2(long time) {
        return DateFormat.format("yyyy-MM-dd", time);
    }


    //初始化时钟
    public static String initClock(TextView clockTv) {
        long sysTime = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(sysTime);
        String dateStr = simpleDateFormat.format(date);
        if (clockTv != null)
            clockTv.setText(dateStr);
        return dateStr;
    }


    //初始化时钟
    public static String initHours(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    //得到月份
    public static String getMonth(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    public static String getLastMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(c.getTime());
    }

    //初始化时钟
    public static String initMin(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

}
