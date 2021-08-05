package com.springcore.workers.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

public class BaseBallCoach implements Coach {

  final private FortuneService fortuneService;

  public BaseBallCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 30 min on batting practice";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
