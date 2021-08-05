package com.springcore.workers.impl;

import com.springcore.workers.FortuneService;

import org.springframework.stereotype.Component;

@Component
public class RESTfortuneService implements FortuneService {

  public RESTfortuneService() {
    System.out.println(">> RESTfortuneService cons");
  }

  @Override
  public String getFortune() {
    return "Hit the REST api";
  }

}
