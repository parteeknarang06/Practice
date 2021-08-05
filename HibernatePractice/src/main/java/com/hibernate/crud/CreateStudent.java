package com.hibernate.crud;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CreateStudent {

  public static void main(String[] args) throws ParseException {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class);
    Session session = factory.getCurrentSession();
    try {
      Student student1 = new Student("parteek", "narang", "pn@gmail.com", CommonUtil.getParsedDate("23/01/1991"));
      Student student2 = new Student("Daffy", "Duck", "pn1@gmail.com", CommonUtil.getParsedDate("12/12/1993"));
      Student student3 = new Student("John", "martin", "pn2@gmail.com", CommonUtil.getParsedDate("02/01/1995"));
      
      Transaction transaction = session.beginTransaction();
      session.save(student1);
      session.save(student2);
      session.save(student3);
      transaction.commit();
    } finally {
      session.close();
      factory.close();
    }
  }

}
