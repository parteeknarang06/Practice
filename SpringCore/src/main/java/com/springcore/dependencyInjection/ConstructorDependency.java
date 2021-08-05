package com.springcore.dependencyInjection;

import com.springcore.workers.Coach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorDependency {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Coach coach = context.getBean("trackCoach", Coach.class);
    System.out.println();
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    coach = context.getBean("baseBallCoach", Coach.class);
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    
    context.close();
  }

}
