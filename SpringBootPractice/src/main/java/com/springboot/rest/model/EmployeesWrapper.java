package com.springboot.rest.model;

import java.util.List;

public class EmployeesWrapper {

  private List<Employee> data;

  public List<Employee> getData() {
    return data;
  }

  public void setData(List<Employee> data) {
    this.data = data;
  }

}
