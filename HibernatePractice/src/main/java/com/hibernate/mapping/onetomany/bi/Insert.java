package com.hibernate.mapping.onetomany.bi;

import java.util.HashSet;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.CommonUtil;

public class Insert {

  public static void main(String[] args) {
    SessionFactory sessionFactory = CommonUtil.getSessionFactory(CommonUtil.HIBERNATE_POSTGRES, Instructor.class,
        InstructorDetail.class);
    try (Session session = sessionFactory.getCurrentSession()) {
      session.setHibernateFlushMode(FlushMode.MANUAL);
      Transaction trans =  session.beginTransaction();
      
      InstructorDetail instructorDetail = new InstructorDetail("luv2code/you", "tennis", new HashSet<Instructor>());
      
      Instructor instructor1 = new Instructor("parteek", "narang", "pn@gmail.com");
      instructor1.setInstructorDetail(instructorDetail);
      
      Instructor instructor2 = new Instructor("chad", "derby", "cd@gmail.com");
      instructor2.setInstructorDetail(instructorDetail);
      
      instructorDetail.getInstructors().add(instructor1);
      //instructorDetail.getInstructors().add(instructor2);
      
      //session.save(instructorDetail);
      session.save(instructor1);
      
      trans.commit();
    } finally {
      sessionFactory.close();
    }
  }

}
