package com.springcore.workers.impl;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;

public class CricketCoach implements Coach {

  private FortuneService cricFortune;
  private String team;
  private String email;

  public CricketCoach() {
    System.out.println("CricketCoach cons");
  }

  @Override
  public String getDailyWorkout() {
    return "Go and practice googly";
  }

  @Override
  public String getDailyFortune() {
    return "come on:" + cricFortune.getFortune();
  }

  public void setFortuneService(FortuneService fortuneService) {
    System.out.println("CricketCoach inside fortuneService setter method");
    this.cricFortune = fortuneService;
  }

  public void setTeam(String team) {
    System.out.println("CricketCoach inside Team setter method");
    this.team = team;
  }

  public void setEmail(String email) {
    System.out.println("CricketCoach inside Email setter method");
    this.email = email;
  }

  public String getTeam() {
    return team;
  }

  public String getEmail() {
    return email;
  }
  
  public void doStart() {
    System.out.println("CricketCoach doStart");
  }

  public void doEnd() {
    System.out.println("CricketCoach doEnd");
  }
  
}
