package com.hibernate.stages.detached;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

public class Detached {

  public static void main(String[] args) {
    SessionFactory sessionFactory = CommonUtil.getSessionFactory(CommonUtil.HIBERNATE_POSTGRES, Student.class);
    try {
      detachedOnClose(sessionFactory);
      detachedMethod(sessionFactory);
      detachedMethod1(sessionFactory);
    } finally {
      sessionFactory.close();
    }

  }

  private static void detachedOnClose(SessionFactory sessionFactory) {
    Session session = sessionFactory.openSession();
    // session.setHibernateFlushMode(FlushMode.MANUAL);
    System.out.println("detachedOnClose:");
    Transaction trans = session.beginTransaction();
    Student student1 = insert(session); // Persistent
    System.out.println(student1);
    trans.commit();
    session.close();

    session = sessionFactory.openSession();
    trans = session.beginTransaction();
    student1.setEmail("3"); // detached
    session.merge(student1); // detached to persistent
    System.out.println(student1);
    trans.commit();
    session.close();
  }

  private static void detachedMethod(SessionFactory factory) {
    try (Session session = factory.openSession()) {
      System.out.println("\ndetachedMethod:");
      
      Transaction transaction = session.beginTransaction();
      Student student = insert(session);
      System.out.println("after insert:");
      System.out.println(student);
      session.detach(student);
      student.setEmail("1");
      transaction.commit();
      
      transaction = session.beginTransaction();
      student = session.get(Student.class, student.getId());
      System.out.println("after detach:");
      System.out.println(student);
      student.setEmail("my@gmail.com");
      session.merge(student);
      transaction.commit();
    }
  }
  
  private static void detachedMethod1(SessionFactory factory) {
    try (Session session = factory.openSession()) {
      System.out.println("\ndetachedMethod:");
      
      Transaction transaction = session.beginTransaction();
      Student student = insert(session);
      System.out.println("after insert:");
      System.out.println(student);
      session.detach(student);
      student.setEmail("1");
      transaction.commit();
      
      transaction = session.beginTransaction();
      student = session.get(Student.class, student.getId());
      System.out.println("after detach:");
      System.out.println(student);
      session.detach(student);
      student.setEmail("my@gmail.com");
      session.persist(student);
      transaction.commit();
    }
  }
  
  private static Student insert(Session session) {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(System.currentTimeMillis());
    Student student = new Student("Parteek", "Narang", "pn@gmail.com", cal); // transient
    session.save(student);
    return student;
  }

  private static Student persist(Session session) {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(System.currentTimeMillis());
    Student student = new Student("Parteek", "Narang", "pn@gmail.com", cal);
    session.persist(student);
    return student;
  }

}
