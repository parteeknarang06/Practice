package com.java.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerDemo2 {

  public static void main(String[] args) throws InterruptedException, ParseException {
    WorkerB obj = new WorkerB(true);
    Timer timer = new Timer();
    //timer.schedule(obj, 5 *1000, 5 *1000);
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
    System.out.println(format.format(new Date()));
    System.out.println(format.parse("18-05-2021 05:15:00 PM") );
    timer.schedule(obj, 1 *1000, 11 * 1000);
    //timer.scheduleAtFixedRate(obj, 1 *1000, 5 * 1000);
    System.out.println("Task scheduled at:" + new Date()+"\n");
    //timer.schedule(obj, format.parse("18-05-2021 05:15:00 PM"));
    
    //System.out.println("Task rescheduled at:" + new Date()+"\n");
  }

}
