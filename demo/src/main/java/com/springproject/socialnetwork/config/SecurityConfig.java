package com.springproject.socialnetwork.config;

import com.springproject.socialnetwork.filters.JwtRequestFilter;
import com.springproject.socialnetwork.repositories.UserRepository;
import com.springproject.socialnetwork.services.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration of the Spring Security.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private JwtRequestFilter jwtRequestFilter;

  @Autowired
  private UserRepository userRepository;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(username -> userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("Username" + username + " not found")))
      .passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().headers().frameOptions().disable();
    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    http.authorizeRequests()
      .antMatchers(HttpMethod.POST, "/authenticate").permitAll()
      .antMatchers(HttpMethod.POST, "/register").permitAll()
      .anyRequest().authenticated()
      .and()
      .exceptionHandling().and().sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
  }

  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}