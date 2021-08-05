package com.springcore.workers.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

public class TrackCoach implements Coach {

  final private FortuneService fortuneService;

  public TrackCoach(FortuneService fortuneService) {
    System.out.println("TrackCoach cons");
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }

  @Override
  public String getDailyFortune() {
    return "Just do it:" + fortuneService.getFortune();
  }

}
