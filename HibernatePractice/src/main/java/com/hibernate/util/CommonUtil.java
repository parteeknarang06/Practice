package com.hibernate.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
  public static Calendar getParsedDate(String strDate) throws ParseException {
    Calendar cal = Calendar.getInstance();
    Pattern pattern = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
    Matcher matcher = pattern.matcher(strDate);
    if (matcher.find()) {
      cal.set(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(2)),
          Integer.parseInt(matcher.group(1)));
    }
    return cal;
  }

}
