package com.hibernate.mapping.onetoone.bi.cascadespecific;

import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Delete {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory(CommonUtil.HIBERNATE_MYSQL, Instructor.class,
        InstructorDetail.class);
    try (Session session = factory.getCurrentSession()) {
      Transaction trans = session.beginTransaction();
      int instructorDetailId = 15;
      InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
      System.out.println("instructorDetail:" + instructorDetail);
      System.out.println("instructor:" + instructorDetail.getInstructor());
      instructorDetail.getInstructor().setInstructorDetail(null);
      session.delete(instructorDetail);
      trans.commit();
    } finally {
      factory.close();
    }
  }

}
