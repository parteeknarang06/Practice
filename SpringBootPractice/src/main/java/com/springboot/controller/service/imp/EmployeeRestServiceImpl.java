package com.springboot.controller.service.imp;

import com.springboot.controller.service.EmployeeRestService;
import com.springboot.rest.EmployeeJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRestServiceImpl implements EmployeeRestService {

  @Autowired
  EmployeeJson employeeJson;
  
  @Override
  public String findbById(int id) {
    List<String> emails = employeeJson.getEmails(String.valueOf(id));
    String finalValue = null;
    if (emails.stream().anyMatch(element -> element.equals("404"))) {
      finalValue = String.join(" ", emails);
    } else {
      finalValue=emails.get(0);
    }
    return finalValue;
  }

  @Override
  public List<String> findAll() {
    return employeeJson.getEmails();
  }

}
