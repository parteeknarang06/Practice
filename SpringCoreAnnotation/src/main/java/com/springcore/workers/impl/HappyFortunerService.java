package com.springcore.workers.impl;

import com.springcore.workers.FortuneService;

import org.springframework.stereotype.Component;

@Component
public class HappyFortunerService implements FortuneService {

  public HappyFortunerService() {
    System.out.println(">> HappyFortunerService cons");
  }

  @Override
  public String getFortune() {
    return "Today is your lucky day!";
  }

}
