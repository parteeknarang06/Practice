package com.springcore.workers.coach.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

public class FootBallCoach implements Coach {

  private FortuneService fortuneService;

  public FootBallCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Take 30 rounds for warm up";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
