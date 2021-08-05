package com.hibernate.crud;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReadAndCreateStudent {

  public static void main(String[] args) throws ParseException {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class);
    try {
      Session session = factory.getCurrentSession();
      
      Student student2 = new Student("Daffy", "Duck", "daffy@gmail.com", CommonUtil.getParsedDate("12/12/1993"));
      Transaction transaction = session.beginTransaction();
      System.out.println(student2);
      session.save(student2);
      transaction.commit();
      System.out.println(student2);
      
      session = factory.getCurrentSession();
      transaction = session.beginTransaction();
      Student student = session.get(Student.class, student2.getId());
      transaction.commit();
      System.out.println(student);
      
    } finally {
      factory.close();
    }
  }

}
