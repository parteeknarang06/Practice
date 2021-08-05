package com.hibernate.mapping.onetoone.bi.cascadeall;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.CommonUtil;

public class Insert {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory(CommonUtil.HIBERNATE_POSTGRES, Instructor.class,
        InstructorDetail.class);
    try (Session session = factory.getCurrentSession()) {
      Transaction trans = session.beginTransaction();
      
      Instructor instructor1 = new Instructor("Chad", "Derby", "cd@gmail.com");
      instructor1.setInstructorDetail(new InstructorDetail("https://www.youtube.com/cd", "football"));
      session.save(instructor1);
      
      InstructorDetail instructorDetail2 = new InstructorDetail("https://www.youtube.com/pn", "cricket");
      Instructor instructor2 = new Instructor("Parteek", "Narang", "pn@gmail.com");
      instructor2.setInstructorDetail(instructorDetail2);
      instructorDetail2.setInstructor(instructor2);
      session.save(instructorDetail2);
      
      trans.commit();
    } finally {
      factory.close();
    }

  }

}
