package com.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sunjx on 2017/11/3.
 */
public class SimpleDateFormatTest {


    public static void main(String[] args) {

        //演示多线程环境下 simpledateformat 错误
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String[] dates = {
                "2017-11-03 00:00:00",
                "2017-11-04 00:00:00",
                "2017-11-05 00:00:00",
                "2017-11-06 00:00:00",
                "2017-11-07 00:00:00",
                "2017-11-08 00:00:00",
                "2017-11-09 00:00:00",
                "2017-11-01 00:00:00",
                "2017-11-02 00:00:00",
                "2017-11-11 00:00:00"};

        for (int i = 0; i < dates.length; i++) {
            String dateStr = dates[i];
            new Thread(() -> {
                try {
                    Date date = sdf.parse(dateStr);
                    String dateString = sdf.format(date);

                    if (!dateStr.equals(dateString)) {
                        System.out.println("出错了，字符串为 " + dateStr + " , 转换后变为 " + dateString);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }


}
