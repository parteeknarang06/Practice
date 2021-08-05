package com.springcore.beanscopes;

import com.springcore.workers.FortuneService;
import com.springcore.workers.Team;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanCycle-applicationContext.xml");
    Team cricketTeam = context.getBean("cricketTeam", Team.class);
    System.out.println("\n"+cricketTeam.getCountryName());
    System.out.println(cricketTeam.getTeamName());
    
    FortuneService FortuneService = context.getBean("fortuneService", FortuneService.class);
    System.out.println("\n"+FortuneService.getFortune());
    context.close();
  }

}
