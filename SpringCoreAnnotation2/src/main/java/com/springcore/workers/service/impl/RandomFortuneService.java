package com.springcore.workers.service.impl;

import com.springcore.workers.FortuneService;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("randomService")
public class RandomFortuneService implements FortuneService {

  @Value("${random.fortune.1}, ${random.fortune.2}, ${random.fortune.3}")
  private String[] data;

  private Random random = new Random();

  public RandomFortuneService() {
    System.out.println(">> RandomFortuneService cons");
  }

  @Override
  public String getFortune() {
    return data[random.nextInt(data.length)];
  }

}
