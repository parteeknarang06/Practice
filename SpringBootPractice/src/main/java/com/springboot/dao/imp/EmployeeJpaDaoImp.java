package com.springboot.dao.imp;

import com.springboot.dao.EmployeeDao;
import com.springboot.dao.entity.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "jpa")
public class EmployeeJpaDaoImp implements EmployeeDao {

  private EntityManager manager;
  
  @Autowired
  public EmployeeJpaDaoImp(EntityManager manager) {
    this.manager = manager;
  }

  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> query = manager.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }

  @Override
  public Employee findById(int id) {
    Employee emp = manager.find(Employee.class, id);
    return emp;
  }

  @Override
  public void saveEmployee(Employee employee) {
    Employee emp = manager.merge(employee);
    employee.setId(emp.getId());
  }

  @Override
  public void deleteById(int employeeId) {
    Employee emp = manager.find(Employee.class, employeeId);
    manager.remove(emp);
  }

}
