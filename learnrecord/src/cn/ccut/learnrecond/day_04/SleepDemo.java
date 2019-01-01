package cn.ccut.learnrecond.day_04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SleepDemo {
    public static void main(String[] args) throws InterruptedException {
        Calendar c = Calendar.getInstance();
        long endTime = c.getTimeInMillis() + 1000 * 10L;

        while (endTime != c.getTimeInMillis()) {
            System.out.println(new SimpleDateFormat("mm:ss").format(new Date(endTime)));
            Thread.sleep(1000);
            endTime -= 1000;
        }
    }
}
