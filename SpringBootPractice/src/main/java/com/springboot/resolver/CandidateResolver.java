package com.springboot.resolver;

import com.springboot.controller.service.EmployeeService;
import com.springboot.dao.EmployeeDao;
import com.springboot.employee.security.SecurityDevice;
import com.springboot.employee.security.imp.BiometricLock;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:sports.properties")
//@PropertySource("classpath:datasource.properties")
public class CandidateResolver {

  @Value("${dao.vendor}")
  private String dao;
 
  @Value("${service.name}")
  private String serviceName;
  
  @Value("${dao.vendor}")
  private String name;
  
  @Autowired
  private ApplicationContext context;
  
  @Bean
  //@Qualifier("runDao")
  @Primary
  public EmployeeDao getEmployeeDao() {
	  System.out.println(name);
    return context.getBean(dao, EmployeeDao.class);
  }
  
  @Bean
  @Primary
  public EmployeeService getEmployeeService() {
    return context.getBean(serviceName, EmployeeService.class);
  }
  
  @Bean
  public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }
  
  @Bean
  public SecurityDevice biometricLock() {
    return new BiometricLock(CandidateResolver.class.getName());
  }
  
  //@Bean
  //@ConfigurationProperties("app.datasource")
  public DataSource getDataSource() {
    return DataSourceBuilder.create().build();
  } 
}
