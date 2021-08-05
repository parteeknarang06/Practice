package com.springcore.workers.impl;

import com.springcore.workers.Team;

public class CricketTeam implements Team {

  private String teamName;
  private String countryName;

  @Override
  public String getTeamName() {
    return teamName;
  }

  @Override
  public String getCountryName() {
    return countryName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public void doStart() {
    System.out.println("CricketTeam doStart");
  }

  public void doEnd() {
    System.out.println("CricketTeam doEnd");
  }
}
