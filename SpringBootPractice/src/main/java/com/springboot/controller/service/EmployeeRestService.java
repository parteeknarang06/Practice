package com.springboot.controller.service;

import java.util.List;

public interface EmployeeRestService {

  List<String> findAll();
  
  String findbById(int id);
}
