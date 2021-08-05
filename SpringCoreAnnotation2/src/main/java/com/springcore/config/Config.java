package com.springcore.config;

import com.springcore.workers.Coach;
import com.springcore.workers.FortuneService;
import com.springcore.workers.coach.impl.FootBallCoach;
import com.springcore.workers.coach.impl.SwimCoach;
import com.springcore.workers.service.impl.DatabaseFortuneService;
import com.springcore.workers.service.impl.RESTfortuneService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.springcore.workers")
@PropertySource("classpath:sports.properties")
public class Config {
  
  @Bean
  @Qualifier("databaseFortuneService")
  public FortuneService getDatabaseFortuneService() {
    System.out.println("databaseFortuneService bean created");
    return new DatabaseFortuneService();
  }
  
  @Bean
  @Qualifier("RESTfortuneService")
  @Scope("prototype")
  public FortuneService getRESTfortuneService() {
    System.out.println("RESTfortuneService bean created");
    return new RESTfortuneService();
  }
  
  @Bean
  @Scope("prototype")
  public Coach swimCoach() {
    System.out.println("swimCoach bean created");
    return new SwimCoach();
  }
  
  @Bean
  @Scope("prototype")
  public Coach footballCoach() {
    System.out.println("footballCoach bean created");
    return new FootBallCoach(getRESTfortuneService());
  }
  
}
