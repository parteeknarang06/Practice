package com.hibernate.crud;

import com.hibernate.entities.Student;
import com.hibernate.util.CommonUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DeleteStudent {

  public static void main(String[] args) {
    SessionFactory factory = CommonUtil.getSessionFactory("hibernate-postgres.cfg.xml", Student.class);
    try {
      Session session = factory.getCurrentSession();
      Transaction transaction = session.beginTransaction();
      
      Student student = session.get(Student.class, 25);
      session.delete(student);
      transaction.commit();
      
      session = factory.getCurrentSession();
      transaction = session.beginTransaction();
      Query query = session.createQuery("delete from Student s where s.firstName= :fname ");
      query.setParameter("fname", "Daffy");
      query.executeUpdate();
      
      transaction.commit();
    } finally {
      factory.close();
    }
  }

}
