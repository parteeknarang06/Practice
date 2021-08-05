package com.springmvc.validation;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

  private String[] coursePrefix;
  
  @Override
  public boolean isValid(String targetText, ConstraintValidatorContext constraintValidatorContext) {
    AtomicBoolean result = new AtomicBoolean(false);
    Arrays.asList(coursePrefix).stream()
        .filter(prefix -> Optional.ofNullable(targetText).isPresent() && targetText.startsWith(prefix))
        .forEach(prefix -> {
          result.set(true);
        });
    return result.get();
  }

  @Override
  public void initialize(CourseCode constraintValues) {
    coursePrefix = constraintValues.value();
  }

}
