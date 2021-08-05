package com.springboot.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  @Autowired
  private MyUserDetailService myUserDetailService;

  @Autowired
  private JwtUtil jwtUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    final String authorizationHeader = request.getHeader("Authorization");
    String username = null;
    String jwt = null;
    if (Optional.ofNullable(authorizationHeader).isPresent()) {
      jwt = authorizationHeader;
      username = jwtUtil.extractUsername(jwt);
    }
    if (Optional.ofNullable(username).isPresent() && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = myUserDetailService.loadUserByUsername(username);
      if (jwtUtil.validateToken(jwt, userDetails)) {
        UsernamePasswordAuthenticationToken userPassAuthToken = new UsernamePasswordAuthenticationToken(userDetails,
            null, userDetails.getAuthorities());
        userPassAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);
      }
    }
    filterChain.doFilter(request, response);
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    String servletPath = request.getServletPath();
    if (Optional.ofNullable(servletPath).isPresent() && servletPath.startsWith("/authenticate")) {
      return true;
    }
    return false;
  }
  
}
