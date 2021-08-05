package com.springcore.workers.service.impl;

import com.springcore.workers.FortuneService;

public class DatabaseFortuneService implements FortuneService {

  public DatabaseFortuneService() {
    System.out.println(">> DatabaseFortuneService cons");
  }

  @Override
  public String getFortune() {
    return "Connect to database";
  }

}
