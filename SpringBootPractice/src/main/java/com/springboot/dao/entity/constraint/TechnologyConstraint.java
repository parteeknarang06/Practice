package com.springboot.dao.entity.constraint;

import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TechnologyConstraint implements ConstraintValidator<Technology, String> {

  private String[] technologies;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return Stream.of(technologies).anyMatch(tech -> tech.equalsIgnoreCase(value));
  }

  @Override
  public void initialize(Technology constraintAnnotation) {
    technologies = constraintAnnotation.value();
  }

}
