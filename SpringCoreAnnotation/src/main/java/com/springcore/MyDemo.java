package com.springcore;

import com.springcore.workers.Coach;
import com.springcore.workers.impl.BaseBallCoach;
import com.springcore.workers.impl.BaseketBallCoach;
import com.springcore.workers.impl.CricketCoach;
import com.springcore.workers.impl.TennisCoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDemo {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Coach coach = context.getBean("thatSillyCoach", TennisCoach.class);
    System.out.println("\n"+coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("cricketCoach", CricketCoach.class);
    System.out.println("\n" + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("baseBallCoach", BaseBallCoach.class);
    System.out.println("\n" + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("baseketBallCoach", BaseketBallCoach.class);
    System.out.println("\n" + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    context.close();
  }

}
