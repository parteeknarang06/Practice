package com.springboot.dao.imp;

import com.springboot.dao.EmployeeDao;
import com.springboot.dao.entity.Employee;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "hibernate")
public class EmployeeHibernateDaoImp implements EmployeeDao {

  private EntityManager entityManager;

  @Autowired
  public EmployeeHibernateDaoImp(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    SessionFactory sessionFactory = entityManager.unwrap(SessionFactory.class);
    sessionFactory.close();
    Session session = entityManager.unwrap(Session.class);
    List<Employee> resultList;
//    NativeQuery<Employee> emp = session.createNativeQuery("select * from employee", Employee.class);
//    resultList = emp.getResultList();
    Query<Employee> query = session.createQuery("from Employee", Employee.class);
    resultList = query.getResultList();
    return resultList;
  }

  @Override
  public Employee findById(int id) {
    Session session = entityManager.unwrap(Session.class);
    return session.get(Employee.class, id);
  }

  @Override
  public void saveEmployee(Employee employee) {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(employee);
  }

  @Override
  public void deleteById(int employeeId) {
    Session session = entityManager.unwrap(Session.class);
    Employee emp = session.load(Employee.class, employeeId);
    session.delete(emp);
  }

}
