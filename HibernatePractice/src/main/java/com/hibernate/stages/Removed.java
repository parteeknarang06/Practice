package com.hibernate.stages;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

public class Removed {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory(CommonUtil.HIBERNATE_POSTGRES, Student.class);
    try {
      int studentId = 20;
      Session session = factory.openSession();
      Transaction trans = session.beginTransaction();
      Student student = session.get(Student.class, studentId);
      System.out.println("Before remove: " + student);
      session.remove(student);
      //trans.rollback();
      
      //trans.commit();
      //trans = session.beginTransaction();
      student.setEmail("1");
      session.persist(student);
      trans.commit();
      session.close();
    } finally {
      factory.close();
    }
    System.runFinalization();
  }

}
