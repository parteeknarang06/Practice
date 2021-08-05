package com.hibernate.mapping.onetoone.uni;

import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Insert {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-mysql.cfg.xml", InstructorDetail.class, Instructor.class);
    try (Session session = factory.getCurrentSession()) {
      Transaction transaction = session.beginTransaction();
      
      Instructor instructor = new Instructor("Parteek", "Narang", "pn@gmail.com");
      InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/my", "chess");
      instructor.setInstructorDetail(instructorDetail);
      System.out.println("instructor1:" + instructor);
      
      Instructor instructor1 = new Instructor("Chad", "derby", "luv2code@gmail.com");
      InstructorDetail instructorDetail1 = new InstructorDetail("www.youtube.com/luv2code.com", "chess");
      instructor1.setInstructorDetail(instructorDetail1);
      System.out.println("instructor2:" + instructor1);
      
      // This will also save instructorDetail because of CascadeType.ALL
      session.save(instructor);
      session.save(instructor1);
      
      transaction.commit();
    } finally {
      factory.close();
    }

  }

}
