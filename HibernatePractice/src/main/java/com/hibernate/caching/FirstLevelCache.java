package com.hibernate.caching;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FirstLevelCache {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class);
    Session session = factory.openSession();
    Transaction trans = session.beginTransaction();
    Student student1 = session.get(Student.class, 29);
    System.out.print("student1 obj: ");
    System.out.println(student1);
    student1.setFirstName("Daffy1");
    
    Student student2 = session.get(Student.class, 29);
    System.out.print("student2 obj: ");
    System.out.println(student2);
    
    
//    trans.commit();
//    student1 = session.get(Student.class, 29);
//    System.out.print("student1 obj after commit: ");
//    System.out.println(student1);
//    session.close();
//    
    
    Session session2 = factory.openSession();
    Transaction trans1 = session2.beginTransaction();
    
    Student student3 = session2.get(Student.class, 29);
    System.out.print("student3 obj: ");
    System.out.println(student3);
    
    trans1.commit();
    session2.close();
  }

}
