package com.springcore.workers.coach.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class SwimCoach implements Coach {

  @Autowired
  @Qualifier("databaseFortuneService")
  private FortuneService service;
  
  public SwimCoach() {
    System.out.println(">> SwimCoach cons");
  }
  
  @Override
  public String getDailyWorkout() {
    return "Swin 1000m as a warm up";
  }

  @Override
  public String getDailyFortune() {
    return service.getFortune();
  }

}
