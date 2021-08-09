package com.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(ConstraintViolationException.class)
  public final ResponseEntity<Object> handleAllExceptions(ConstraintViolationException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    for (ConstraintViolation<?> error : ex.getConstraintViolations()) {
      details.add(error.getMessage());
    }
    Map<String, List<String>> error = new HashMap<String, List<String>>();
    error.put("Validation Failed", details);
    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
  }
  
}
