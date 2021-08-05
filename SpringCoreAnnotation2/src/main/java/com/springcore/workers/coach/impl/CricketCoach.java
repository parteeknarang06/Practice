package com.springcore.workers.coach.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

  private FortuneService fortuneService;
  
  public CricketCoach() {
    System.out.println(">> CricketCoach cons");
  }
  
  @Autowired
  public CricketCoach(@Qualifier("happyFortunerService") FortuneService fortuneService) {
    System.out.println(">> CricketCoach param cons");
    this.fortuneService = fortuneService;
  }
  
  @Override
  public String getDailyWorkout() {
    return "Go and practice googly";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @PostConstruct
  private void doInit() {
    System.out.println("CricketCoach doInit");
  }
  
  @PreDestroy
  private void doEnd() {
    System.out.println("CricketCoach doEnd");
  }
  
}
