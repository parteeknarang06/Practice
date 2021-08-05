package com.springcore.workers.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

  private FortuneService fortuneService;
  
  public BaseBallCoach() {
    System.out.println(">> BaseBallCoach cons invoked");
  }
  
  @Override
  public String getDailyWorkout() {
    return "Spend 30 min on batting practice";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Autowired
  @Qualifier("RESTfortuneService")
  public void invokeFortune(FortuneService fortuneService) {
    System.out.println("BaseBallCoach invoke Fortune");
    this.fortuneService = fortuneService;
  }
  
}
