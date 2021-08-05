package com.springcore.workers.impl;

import com.springcore.workers.FortuneService;

import org.springframework.beans.factory.DisposableBean;

public class HappyFortuneService implements FortuneService, DisposableBean {

  public HappyFortuneService() {
    System.out.println("HappyFortuneService cons");
  }
  
  @Override
  public String getFortune() {
    return "Today is your lucky day";
  }
  
  public void doStart() {
    System.out.println("HappyFortuneService doStart");
  }

  public void doEnd() {
    System.out.println("HappyFortuneService doEnd");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("HappyFortuneService destroy");
  }
}
