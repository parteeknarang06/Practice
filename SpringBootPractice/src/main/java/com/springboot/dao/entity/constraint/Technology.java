package com.springboot.dao.entity.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TechnologyConstraint.class)
@Target(value = { ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Technology {

  public String[] value();

  public String message();

  public Class<?>[] groups() default {};

  public Class<? extends Payload>[] payload() default {};
}
