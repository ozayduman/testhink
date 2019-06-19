package com.ozayduman.testhink.hard2testcode;

import java.util.concurrent.TimeUnit;

public class Util {
    private static Util instance;

    private Util(){
    }
    public static Util getInstance(){
        if(instance == null){
            instance = new Util();
        }
        return instance;
    }

    public static void longRunningJob() {
        try {
            TimeUnit.HOURS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
