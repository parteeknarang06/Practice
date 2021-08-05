package com.springcore.beanscope;

import com.springcore.workers.Coach;
import com.springcore.workers.coach.impl.CricketCoach;
import com.springcore.workers.coach.impl.TennisCoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    Coach tennisCoach = context.getBean("thatSillyCoach", TennisCoach.class);
    Coach tennisCoachAlpha = context.getBean("thatSillyCoach", TennisCoach.class);
    System.out.println();
    System.out.println(tennisCoach == tennisCoachAlpha);
    System.out.println(tennisCoach);
    System.out.println(tennisCoachAlpha);
    
    System.out.println();
    Coach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
    Coach cricketCoachAlpha = context.getBean("cricketCoach", CricketCoach.class);
    System.out.println(cricketCoach == cricketCoachAlpha);
    System.out.println(cricketCoach);
    System.out.println(cricketCoachAlpha);
    System.out.println(cricketCoach.getDailyWorkout());
    context.close();
  }

}
