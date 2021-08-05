package com.springboot.controller;

import com.springboot.security.JwtUtil;
import com.springboot.security.MyUserDetailService;
import com.springboot.security.models.AuthenticationRequest;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private MyUserDetailService userDetailService;
  
  @Autowired
  private JwtUtil jwtUtil;
  
  @Value("${coach.name}")
  private String coachName;

  @Value("${team.name}")
  private String teamName;

  // expose new endpoint
  @GetMapping("/")
  public String getStatus() {
    return "Agent is alive. Server time:" + LocalTime.now();
  }

  @GetMapping("/prop")
  public String getProperty() {
    return "CoachName: " + coachName + " && TeamName: " + teamName;
  }

  @RequestMapping( value = "/authenticate", method = RequestMethod.POST)
  public String createAuthToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
    try {
      Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
          authRequest.getPassword());
      authManager.authenticate(authentication);
    } catch (BadCredentialsException ex) {
      throw new Exception("Incorrect username or password", ex);
    }
    final UserDetails userDetails= userDetailService.loadUserByUsername(authRequest.getUsername());
    final String generateToken = jwtUtil.generateToken(userDetails);
    return generateToken;
  }

}
