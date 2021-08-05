package com.springcore.workers.service.impl;

import com.springcore.workers.FortuneService;

public class RESTfortuneService implements FortuneService {

  public RESTfortuneService() {
    System.out.println(">> RESTfortuneService cons");
  }

  @Override
  public String getFortune() {
    return "Hit the REST api";
  }

}
