package com.springboot.dao.imp;

import com.springboot.dao.EmployeeDao;
import com.springboot.dao.entity.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository(value = "jdbc")
public class EmployeeDaoImpl implements EmployeeDao {

  @Value("${spring.datasource.url}")
  private String url;
  
  @Value("${spring.datasource.username}")
  private String user;
  
  @Value("${spring.datasource.password}")
  private String password;
  
  @Override
  public List<Employee> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Employee findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveEmployee(Employee employee) {
    boolean insert = true;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection(url, user, password);
      if (insert) {
        pstmt = conn.prepareStatement("insert into employee (first_name, last_name, email) values(?,?,?)",
            Statement.RETURN_GENERATED_KEYS);
      } else {
        pstmt = conn.prepareStatement("update employee set first_name =? , last_name=?, email=? where id =?");
      }
      pstmt.setString(1, employee.getFirstName());
      pstmt.setString(2, employee.getLastName());
      pstmt.setString(3, employee.getEmail());
      if (insert) {
        pstmt.execute();
        ResultSet resultSet = pstmt.getGeneratedKeys();
        if (resultSet.next()) {
          employee.setId(resultSet.getInt(1));
        }
      } else {
        pstmt.setInt(4, employee.getId());
        pstmt.executeUpdate();
      }
      
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeResources(null, pstmt, conn);
    }
  }

  private void closeResources(ResultSet resultSet, PreparedStatement pstmt, Connection conn) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (pstmt != null) {
      try {
        pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  @Override
  public void deleteById(int employeeId) {
    // TODO Auto-generated method stub

  }

}
