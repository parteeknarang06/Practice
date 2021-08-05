package com.springboot.controller.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.controller.service.EmployeeSecurityService;
import com.springboot.employee.security.SecurityDevice;

@Service
public class EmployeeSecurityServiceImpl implements EmployeeSecurityService {

  @Autowired
  @Qualifier("biometricLock")
  private SecurityDevice device;
  
  @Override
  public String startDevice() {
    return device.startDevice();
  }

  

}
