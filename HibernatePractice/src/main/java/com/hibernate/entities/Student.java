package com.hibernate.entities;

import java.util.Calendar;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "student", schema = "stages")
public class Student {

  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private Calendar dob;

  public Student() {
    // Hibernate use default constructor
  }

  public Student(String firstName, String lastName, String email, Calendar dob) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dob = dob;
  }

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date_of_birth")
  public Calendar getDob() {
    return dob;
  }

  public void setDob(Calendar dob) {
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob="
        + dob + "]";
  }

}
