package com.springmvc.models;

import com.springmvc.validation.CourseCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

  private String firstName;

  @NotNull(message = "is required")
  @Size(min = 3, message = "size must be at-least three")
  private String lastName;

  @NotNull(message = "is required")
  @Min(message = "must be greater than or equals to zero", value = 0)
  @Max(message = "must be less than or equals to 10", value = 10)
  private Integer freePasses;

  @Pattern(regexp = "^[0-9A-Za-z]{5}$", message = "only 5 digits/char are allowed")
  private String postalCode;

  @CourseCode(value = {"MVC", "TOPS"}, message = "must starts with MVC or TOPS")
  //@CourseCode
  private String courseCode;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(Integer freePasses) {
    this.freePasses = freePasses;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

}
