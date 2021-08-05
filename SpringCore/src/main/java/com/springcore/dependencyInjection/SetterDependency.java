package com.springcore.dependencyInjection;

import com.springcore.workers.Coach;
import com.springcore.workers.Team;
import com.springcore.workers.impl.CricketCoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDependency {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Coach coach = context.getBean("cricketCoach", Coach.class);
    System.out.println();
    coach = context.getBean("cricketCoach", Coach.class);
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    System.out.println();
    CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
    System.out.println(cricketCoach.getDailyWorkout());
    System.out.println(cricketCoach.getDailyFortune());
    System.out.println(cricketCoach.getTeam());
    System.out.println(cricketCoach.getEmail());
    
    System.out.println();
    Team cricketTeam = context.getBean("cricketTeam", Team.class);
    System.out.println(cricketTeam.getTeamName());
    System.out.println(cricketTeam.getCountryName());
    context.close();
  }

}
