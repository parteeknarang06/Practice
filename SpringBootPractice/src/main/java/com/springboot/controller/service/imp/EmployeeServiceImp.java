package com.springboot.controller.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.controller.service.EmployeeService;
import com.springboot.dao.EmployeeDao;
import com.springboot.dao.entity.Employee;

@Service("service-Jpa")
public class EmployeeServiceImp implements EmployeeService {

  @Autowired
  private EmployeeDao employeeDao;

  @Override
  @Transactional
  public List<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  @Transactional
  public Employee findById(int id) {
    return employeeDao.findById(id);
  }

  @Override
  @Transactional
  public void saveEmployee(Employee employee) {
    employeeDao.saveEmployee(employee);
  }

  @Override
  @Transactional
  public void deleteById(int employeeId) {
    employeeDao.deleteById(employeeId);
  }

}
