package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresJdbc {

  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
    String url = "jdbc:postgresql://localhost:5432/hb_student_tracker?currentSchema=tracker";
    String user = "postgres";
    String password = "postgres";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt = conn.prepareStatement("select * from student")) {
      System.out.println("Connection successfull !!!");
      try (ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
          System.out.println(rs.getInt("id"));
          System.out.println(rs.getString("first_name"));
          System.out.println(rs.getString("last_name"));
          System.out.println(rs.getString("email"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
