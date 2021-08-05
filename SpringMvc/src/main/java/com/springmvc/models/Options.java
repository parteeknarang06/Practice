package com.springmvc.models;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Options {

  private Properties properties;

  @Autowired
  public Options(Properties properties) {
    this.properties = properties;
  }

  public Map<String, String> getCountryOptions() {
    return properties.getCountryOptions();
  }

  public List<String> getProgrammingLanguages() {
    return Arrays.asList(properties.getProgrammingLanguages().split(","));
  }
  
  public List<String> getOperatingSystems() {
    return Arrays.asList(properties.getOperatingSystems().split(","));
  }
}
