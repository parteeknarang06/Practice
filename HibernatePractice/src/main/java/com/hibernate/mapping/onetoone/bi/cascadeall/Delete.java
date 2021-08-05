package com.hibernate.mapping.onetoone.bi.cascadeall;

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
      int instructorDetailId = 18;
      InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId); 
      instructorDetailId = 19;
      Instructor instructor = session.get(Instructor.class, instructorDetailId); 
      
      /*
       * Will delete entry from both tables when cascade type is all.
       * Delete entry from parent will delete entry from child as well and vice versa 
       */
      session.delete(instructorDetail);
      session.delete(instructor);
      
      trans.commit();
    } finally {
      factory.close();
    }
  }

}
