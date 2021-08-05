package com.hibernate.crud;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReadOperations2 {

  public static void main(String[] args) {
    try (SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class);) {
      Session session = factory.getCurrentSession();
      Transaction trans = session.beginTransaction();

      Student s2 = session.load(Student.class, 29);
      System.out.println("Student s2 loaded");
      if (s2 != null) {
        System.out.println("Student 29 exists");
      }

      Student s1 = session.load(Student.class, 2);
      System.out.println("Student s1 load");
      System.out.println("Student s1:" + s1);
      // System.out.println("Student s2:" + s2);
      // System.out.println("Student s2 id:" + s2.getId());
      trans.commit();
    }
  }

}
