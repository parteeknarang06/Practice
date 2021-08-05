package com.springboot.controller.service;

import com.springboot.dao.entity.Employee;

import java.util.List;

public interface EmployeeService {

  public List<Employee> findAll();
  
  public Employee findById(int id);
  
  public void saveEmployee(Employee employee);
  
  public void deleteById(int employeeId);
  
}
