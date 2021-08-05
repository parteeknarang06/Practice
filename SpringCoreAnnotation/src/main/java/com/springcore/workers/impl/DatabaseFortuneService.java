package com.springcore.workers.impl;

import com.springcore.workers.FortuneService;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

  public DatabaseFortuneService() {
    System.out.println(">> DatabaseFortuneService cons");
  }

  @Override
  public String getFortune() {
    return null;
  }

}
