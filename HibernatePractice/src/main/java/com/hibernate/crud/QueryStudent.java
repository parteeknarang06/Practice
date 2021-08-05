package com.hibernate.crud;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class QueryStudent {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class);
    try {
      Session session = factory.getCurrentSession();
      Transaction transaction = session.beginTransaction();
      
      List<Student> resultList = session.createQuery("from Student", Student.class).getResultList();
      displayStudents(resultList);
      
      System.out.println("\nlastName='Duck'");
      resultList = session.createQuery("from Student s where s.lastName='Duck'", Student.class).getResultList();
      displayStudents(resultList);
      
      System.out.println("\nfirstName='Daffy' or s.lastName='narang'");
      resultList = session.createQuery("from Student s where s.firstName='Daffy' OR s.lastName='narang'", Student.class).getResultList();
      displayStudents(resultList);
      
      System.out.println("\nemail like 'pn%'");
      resultList = session.createQuery("from Student s where s.email like 'pn%'", Student.class).getResultList();
      displayStudents(resultList);
      
      System.out.println("\nemail like 'luv%'");
      resultList = session.createQuery("from Student s where s.email like 'luv%'", Student.class).getResultList();
      displayStudents(resultList);
      
      transaction.commit();
    } finally {
      factory.close();
    }
  }

  private static void displayStudents(List<Student> resultList) {
    resultList.forEach(student -> {
      System.out.println(student);
    });
  }

}
