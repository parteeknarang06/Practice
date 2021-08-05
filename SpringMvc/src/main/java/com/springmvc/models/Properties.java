package com.springmvc.models;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

  private Map<String, String> countryOptions;
  private String programmingLanguages;
  private String operatingSystems;
  
  public Map<String, String> getCountryOptions() {
    return countryOptions;
  }

  @Value("#{countryOptions}")
  public void setCountryOptions(Map<String, String> countryOptions) {
    this.countryOptions = countryOptions;
  }

  public String getProgrammingLanguages() {
    return programmingLanguages;
  }

  @Value("#{commonOptions.proprogrammingLanguages}")
  public void setProgrammingLanguages(String programmingLanguages) {
    this.programmingLanguages = programmingLanguages;
  }

  public String getOperatingSystems() {
    return operatingSystems;
  }

  @Value("#{commonOptions.operatingSystems}")
  public void setOperatingSystems(String operatingSystems) {
    this.operatingSystems = operatingSystems;
  }
  
}
