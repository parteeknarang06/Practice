package com.hibernate.mapping.onetoone.uni;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private InstructorDetail instructorDetail;

  public Instructor() {
    // For hibernate
  }

  public Instructor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
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

  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "instructor_detail_id")
  public InstructorDetail getInstructorDetail() {
    return instructorDetail;
  }

  public void setInstructorDetail(InstructorDetail instructorDetail) {
    this.instructorDetail = instructorDetail;
  }

  @Override
  public String toString() {
    return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
        + ", instructorDetail=" + instructorDetail + "]";
  }

}
