package com.springboot.employee.security.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springboot.employee.security.SecurityDevice;
import com.springboot.employee.security.SecurityWrapper;

@Component
public class SecurityWrapperImp implements SecurityWrapper{

  @Autowired
  @Qualifier("biometricLock")
  private SecurityDevice securityDevice;

  @Override
  public String startDevice() {
    return securityDevice.startDevice();
  }

}
