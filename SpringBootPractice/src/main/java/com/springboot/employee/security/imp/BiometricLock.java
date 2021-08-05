package com.springboot.employee.security.imp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.springboot.employee.security.SecurityDevice;

@Component
@Primary
public class BiometricLock implements SecurityDevice {

  private String startBy;

  public BiometricLock() {
    this.startBy = "default start";
  }

  public BiometricLock(String startBy) {
    this.startBy = startBy;
  }

  @Override
  public String startDevice() {
    return "BiometricLock starts type: ".concat(startBy);
  }

}
