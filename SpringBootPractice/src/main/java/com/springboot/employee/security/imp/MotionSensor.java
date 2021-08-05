package com.springboot.employee.security.imp;

import org.springframework.stereotype.Component;

import com.springboot.employee.security.SecurityDevice;

@Component
public class MotionSensor implements SecurityDevice {

  private String startBy;

  public MotionSensor() {
    this.startBy = "default start";
  }

  public MotionSensor(String startBy) {
    this.startBy = startBy;
  }

  @Override
  public String startDevice() {
    return "Motion Sensor starts by ".concat(startBy);
  }

}
