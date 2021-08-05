package com.hibernate.mapping.onetoone.uni;

import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Delete {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-mysql.cfg.xml", Instructor.class,
        InstructorDetail.class);
    try (Session session = factory.getCurrentSession()) {
      Transaction trans = session.beginTransaction();
      int instructorId = 9;
      Instructor instructor = session.get(Instructor.class, instructorId);
      if (instructor != null) {
        session.delete(instructor);
        System.out.println("instructorId:" + instructorId + " deleted");
      }
      trans.commit();
    } finally {
      factory.close();
    }
  }

}
