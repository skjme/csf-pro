package com.chaseshu.biz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumFactory {

    private static  int i = 0;
    public /*synchronized*/ static String createOrderNum(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
        return sdf.format(new Date()) + ++i;
    }
}
