package com.hibernate.stages;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

public class Persistent {

  public static void main(String[] args) {
    SessionFactory sessionFactory = CommonUtil.getSessionFactory(CommonUtil.HIBERNATE_POSTGRES, Student.class);
    try {
      Session session = sessionFactory.openSession();
      // session.setHibernateFlushMode(FlushMode.MANUAL);

      Transaction trans = session.beginTransaction();
      Student student1 = insert(session); // Persistent
      student1.setEmail("1");
      trans.commit();

      Student student = session.get(Student.class, student1.getId());
      System.out.println(student);
      trans = session.beginTransaction();
      student1.setEmail("2");
      trans.commit();

      session.close();

    } finally {
      sessionFactory.close();
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
