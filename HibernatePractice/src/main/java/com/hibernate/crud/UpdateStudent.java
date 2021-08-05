package com.hibernate.crud;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateStudent {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class);
    try {
      Session session = factory.getCurrentSession();
      Transaction transaction = session.beginTransaction();

      Student student = session.get(Student.class, 25);
      student.setEmail("luv2code@gmail.com");
      transaction.commit();

      session = factory.getCurrentSession();
      transaction = session.beginTransaction();
      session.createQuery("update Student s set s.email ='foo@luv2code.com'").executeUpdate();
      transaction.commit();
    } finally {
      factory.close();
    }
  }

}
