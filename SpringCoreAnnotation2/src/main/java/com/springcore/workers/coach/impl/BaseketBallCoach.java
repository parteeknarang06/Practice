package com.springcore.workers.coach.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseketBallCoach implements Coach {

  public BaseketBallCoach() {
    System.out.println(">> BaseketBallCoach cons invoked");
  }
  
  @Autowired
  @Qualifier("randomService")
  private FortuneService fortuneService;
  
  @Override
  public String getDailyWorkout() {
    return "Go and practice baskets";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
