package com.springmvc.controller;

import com.springmvc.common.CommonUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

  @RequestMapping(method = RequestMethod.GET, path= "/")
  public String loginPage() {
    return CommonUtil.LOGIN;
  }
  
}
