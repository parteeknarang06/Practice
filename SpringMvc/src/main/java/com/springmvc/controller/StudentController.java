package com.springmvc.controller;

import com.springmvc.common.CommonUtil;
import com.springmvc.models.Options;
import com.springmvc.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {
  
  @Autowired
  private Options options;
  
  @RequestMapping(method = RequestMethod.GET, path = "")
  public String mainPage() {
    return CommonUtil.MAIN_MENU;
  }
  
  @RequestMapping(method = RequestMethod.GET, path = "/showForm")
  public String showForm(Model model) {
    Student student = new Student();
    student.setFirstName("demo first name");
    student.setLastName("demo last name");
    model.addAttribute("student", student);
    model.addAttribute("theCountryOptions", options.getCountryOptions());
    model.addAttribute("proprogrammingLanguages", options.getProgrammingLanguages());
    model.addAttribute("operatingSystems", options.getOperatingSystems());
    return CommonUtil.STUDENT_FORM;
  }
  
  @RequestMapping(method = RequestMethod.POST, path = "/processForm")
  public String processForm(Model model, @ModelAttribute("student") Student student ) {
    System.out.println("Model map:" + model.asMap());
    System.out.println(student);
    return CommonUtil.STUDENT_CONFIRMATION;
  }
  
}
