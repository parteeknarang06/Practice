package com.hibernate.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CommonUtil {

  public static final String HIBERNATE_MYSQL;
  public static final String HIBERNATE_POSTGRES;

  static {
    HIBERNATE_MYSQL = "hibernate-mysql.cfg.xml";
    HIBERNATE_POSTGRES = "hibernate-postgres.cfg.xml";
  }

  public static SessionFactory getSessionFactory(String file, Class<?>... entities) {
    Configuration config = new Configuration();
    config.configure(file);
    for (Class<?> entity : entities) {
      config.addAnnotatedClass(entity);
    }
    return config.buildSessionFactory();
  }

  /**
   * Convert "dd/MM/yyyy" string date to SQL date.
   * 
   * @param strDate date in string form
   * @return sql date
   * @throws ParseException
   */
  public static Date getParsedDate(String strDate) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    return new Date(format.parse(strDate).getTime());
  }

}
