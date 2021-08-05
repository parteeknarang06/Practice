package com.springcore.beancycle;

import com.springcore.workers.Coach;
import com.springcore.workers.Team;
import com.springcore.workers.impl.CricketCoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanCycle-applicationContext.xml");
    Coach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
    Coach cricketCoachAlpha = context.getBean("cricketCoach", CricketCoach.class);
    System.out.println("\npointing to same object: " + (cricketCoach == cricketCoachAlpha));
    System.out.println("Memory loc for cricketCoach: " + cricketCoach);
    System.out.println("Memory loc for cricketCoachAlpha: " + cricketCoachAlpha);
    
    Team team = context.getBean("cricketTeam", Team.class);
    Team teamAlpha = context.getBean("cricketTeam", Team.class);
    System.out.println("\npointing to same object: " + (team == teamAlpha));
    System.out.println("Memory loc for cricketCoach: " + team);
    System.out.println("Memory loc for cricketCoachAlpha: " + teamAlpha);
    context.close();
  
  }

}
