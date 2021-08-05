package com.springmvc.controller;

import com.springmvc.common.CommonUtil;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {

  @RequestMapping("")
  public String mainPage() {
    return CommonUtil.MAIN_MENU;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/showForm")
  public String showForm() {
    return CommonUtil.HELLO_WORLD_FORM;
  }

  @RequestMapping(method = RequestMethod.POST, path = "/processForm")
  public String processForm() {
    return CommonUtil.HELLO_WORLD;
  }

  @RequestMapping(method = RequestMethod.POST, path = "processFormTwo")
  public String letsShoutDude(HttpServletRequest request, Model model) {
    String name = request.getParameter("studentName");
    model.addAttribute("message", "Yo! v2 " + name.toUpperCase());
    return CommonUtil.HELLO_WORLD;
  }

  @RequestMapping(method = RequestMethod.POST, path = "processFormThree")
  public String letsShoutDudeAgain(@RequestParam("studentName") String theName, Model model) {
    model.addAttribute("message", "Hey dude! v3 " + theName.toUpperCase());
    return CommonUtil.HELLO_WORLD;
  }

}
