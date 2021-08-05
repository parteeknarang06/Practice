package com.springcore;

import com.springcore.config.Config;
import com.springcore.workers.Coach;
import com.springcore.workers.coach.impl.BaseBallCoach;
import com.springcore.workers.coach.impl.BaseketBallCoach;
import com.springcore.workers.coach.impl.CricketCoach;
import com.springcore.workers.coach.impl.FootBallCoach;
import com.springcore.workers.coach.impl.SwimCoach;
import com.springcore.workers.coach.impl.TennisCoach;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    Coach coach = context.getBean("thatSillyCoach", TennisCoach.class);
    System.out.println("\nthatSillyCoach: "+coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("cricketCoach", CricketCoach.class);
    System.out.println("\ncricketCoach: " + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("baseBallCoach", BaseBallCoach.class);
    System.out.println("\nbaseBallCoach: " + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("baseketBallCoach", BaseketBallCoach.class);
    System.out.println("\nbaseketBallCoach: " + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("swimCoach", SwimCoach.class);
    System.out.println("\nswimCoach: " + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("swimCoach", SwimCoach.class);
    System.out.println("\nswimCoach: " + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("footballCoach", FootBallCoach.class);
    System.out.println("\nfootballCoach: " + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("footballCoach", FootBallCoach.class);
    System.out.println("\nfootballCoach: " + coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    context.close();
  }

}
