package com.springproject.socialnetwork.services.impl;

import com.springproject.socialnetwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service implementation of UserDetails interface.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  /**
   * Getting user details by username.
   *
   * @param username the username identifying the user whose data is required.
   * @return User details.
   * @throws UsernameNotFoundException - user not found.
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username).orElseThrow(()
      -> new UsernameNotFoundException("No such user " + username));
  }
}
