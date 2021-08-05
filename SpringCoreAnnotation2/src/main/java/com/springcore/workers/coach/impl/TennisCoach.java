package com.springcore.workers.coach.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {

  private FortuneService fortuneService;
  
  public TennisCoach() {
    System.out.println(">> TennisCoach cons invoked");
  }
  
  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Autowired
  @Qualifier("happyFortunerService")
  public void setFortuneService(FortuneService fortuneService) {
    System.out.println("TennisCoach setFortuneService called");
    this.fortuneService = fortuneService;
  }

  @PostConstruct
  private void doInit() {
    System.out.println("TennisCoach doInit");
  }
  
  @PreDestroy
  private void doEnd() {
    System.out.println("TennisCoach doEnd");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("TennisCoach destroy");
  }
  
}
