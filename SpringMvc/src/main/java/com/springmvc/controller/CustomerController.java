package com.springmvc.controller;

import com.springmvc.common.CommonUtil;
import com.springmvc.models.Customer;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @RequestMapping(method = RequestMethod.GET, path = "")
  public String mainPage() {
    return CommonUtil.MAIN_MENU;
  }
  
  @RequestMapping(method = RequestMethod.GET, path = "/showForm")
  public String showForm(Model model) {
    model.addAttribute("customer", new Customer());
    return CommonUtil.CUSTOMER_FORM;
  }
  
  @RequestMapping(method = RequestMethod.POST, path = "/processForm")
  public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
    System.out.println("last name: |" + customer.getLastName() + "|");
    System.out.println("bindingResult:" + bindingResult);
    if (bindingResult.hasErrors()) {
      return CommonUtil.CUSTOMER_FORM;
    }
    return CommonUtil.CUSTOMER_CONFIRMATION;
  }
  
  @InitBinder
  public void intiBinder(WebDataBinder webDataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }
  
}
