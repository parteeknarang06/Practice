package com.springcore;

import com.springcore.workers.Coach;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
  // Logger logger = LogManager.getLogger(SpringApp.class);

  public static void main(String[] args) throws IOException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Coach coach = context.getBean("myCoach", Coach.class);
    System.out.println(coach.getDailyWorkout());
    context.close();
  }

}
