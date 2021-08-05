package com.hibernate.crud;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReadOperations1 {

  public static void main(String[] args) {
    try (SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class)) {
      Session session = factory.getCurrentSession();
      Transaction trans = session.beginTransaction();
      Student s1 = session.get(Student.class, 29);
      System.out.println("Student s1 get");
      System.out.println("Student s1:" + s1);

      trans.commit();
    }
  }

}
