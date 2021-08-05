package com.springboot.controller;

import com.springboot.controller.service.EmployeeRestService;
import com.springboot.controller.service.EmployeeSecurityService;
import com.springboot.controller.service.EmployeeService;
import com.springboot.dao.entity.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;
  private EmployeeRestService employeeRestService;
  private EmployeeSecurityService employeeSecurityService;

  @Autowired
  public EmployeeRestController(@Qualifier("service-Jpa") EmployeeService employeeService,
      EmployeeRestService employeeRestService, EmployeeSecurityService employeeSecurityService) {
    this.employeeService = employeeService;
    this.employeeRestService = employeeRestService;
    this.employeeSecurityService = employeeSecurityService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee findById(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);
    if (employee == null) {
      throw new RuntimeException("Employee Id:" + employeeId + " not found");
    }
    return employee;
  }

  @PostMapping("/employees")
  public Employee saveEmployee(@RequestBody Employee employee) {
    employeeService.saveEmployee(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    employeeService.saveEmployee(employee);
    return employee;
  }

  @DeleteMapping("/employees/{employeeId}")
  public void deleteById(@PathVariable int employeeId) {
    employeeService.deleteById(employeeId);
  }

  @GetMapping("/employees/email")
  public List<String> findAllEmails() {
    return employeeRestService.findAll();
  }

  @GetMapping("/employees/email/{employeeId}")
  public String findEmailById(@PathVariable int employeeId) {
    return employeeRestService.findbById(employeeId);
  }
  
  @RequestMapping(value = "/employee/startSecurityDevice", method = RequestMethod.POST)
  public String startSecurityDevice() {
    return employeeSecurityService.startDevice();
  }

}
