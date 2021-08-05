package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlJdbc {

  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
    String user = "root";
    String password = "root";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt = conn.prepareStatement("select * from instructor")) {
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
