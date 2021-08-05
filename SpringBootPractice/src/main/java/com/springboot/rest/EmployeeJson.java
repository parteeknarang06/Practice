package com.springboot.rest;

import com.springboot.rest.model.Employee;
import com.springboot.rest.model.EmployeeWrapper;
import com.springboot.rest.model.EmployeesWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import flexjson.JSONSerializer;

@Component
public class EmployeeJson {

  @Autowired
  RestTemplate restTemplate;
  
  public List<String> getEmails() {
    return getEmails("");
  }
  
  public List<String> getEmails(String id) {
    List<String> emails;
    try {
      if (id.isEmpty()) {
        EmployeesWrapper employees = getResponse(EmployeesWrapper.class, id);
        emails = Optional.ofNullable(employees).isPresent()
            ? employees.getData().stream().map(element -> element.getEmail()).collect(Collectors.toList())
            : Collections.emptyList();
      } else {
        EmployeeWrapper employee = getResponse(EmployeeWrapper.class, id);
        emails = Optional.ofNullable(employee).isPresent() 
            ? new ArrayList<String>(1) {
                private static final long serialVersionUID = 1L;
                {
                  add(employee.getData().getEmail());
                }
              } 
            : Collections.emptyList();
      }
    } catch (HttpClientErrorException ex) {
      emails = new ArrayList<String>() {
        private static final long serialVersionUID = 1L;
        {
          add(String.valueOf(ex.getStatusCode().value()));
          add(ex.getStatusCode().getReasonPhrase());
        }
      };
    }
    return emails;
  }
 
  private <T> T getResponse(Class<T> responseType, String id) {
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<String> entity = new HttpEntity<>(headers);
    String url = String.format("https://reqres.in/api/users/%s", id);
    return restTemplate.exchange(url, HttpMethod.GET, entity, responseType).getBody();
  }
  
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<Employee>() {
      private static final long serialVersionUID = 1L;
      {
        
        Employee emp = new Employee();
        emp.setId(1);
        emp.setEmail("george.bluth@reqres.in");
        emp.setFirst_name("George");
        emp.setLast_name("Bluth");
        emp.setAvatar("https://reqres.in/img/faces/1-image.jpg");
        add(emp);
        emp = new Employee();
        emp.setId(2);
        emp.setEmail("janet.weaver@reqres.in");
        emp.setFirst_name("Janet");
        emp.setLast_name("Weaver");
        emp.setAvatar("https://reqres.in/img/faces/2-image.jpg");
        add(emp);
      }
    };
    JSONSerializer json = new JSONSerializer();
    json.exclude("class");
    System.out.println(json.serialize(employees));
    
  }
}
