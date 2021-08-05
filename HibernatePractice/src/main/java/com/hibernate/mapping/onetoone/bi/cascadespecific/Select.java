package com.hibernate.mapping.onetoone.bi.cascadespecific;

import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Select {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory(CommonUtil.HIBERNATE_MYSQL, InstructorDetail.class, Instructor.class);
    try(Session session = factory.getCurrentSession()) {
      Transaction trans = session.beginTransaction();
      int instructorDetailId = 9;
      InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
      System.out.println(instructorDetail);
      System.out.println(instructorDetail.getInstructor());
      trans.commit();
    } finally {
      factory.close();
    }
  }

}
