package com.springproject.socialnetwork.services.impl;

import com.springproject.socialnetwork.models.AuthenticationRequest;
import com.springproject.socialnetwork.models.AuthenticationResponse;
import com.springproject.socialnetwork.repositories.UserRepository;
import com.springproject.socialnetwork.services.AuthService;
import com.springproject.socialnetwork.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Implementation of the AuthService methods.
 */
@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  /**
   * Create and return jwt token.
   *
   * @param authenticationRequest - the authentication request body.
   * @return jwt token or exception.
   * @throws Exception - bad credentials.
   */
  @Override
  public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {

//    Trying to authorize the user.
    try {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
          authenticationRequest.getPassword())
      );
    }
//    Catching an exception if the credentials are invalid.
    catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password", e);
    }

//    Get UserDetails by username from request.
    final UserDetails userDetails = userDetailsService
      .loadUserByUsername(authenticationRequest.getUsername());

//    Generating token.
    final String jwt = jwtUtil.generateToken(userDetails);

//    Returning OK and token.
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}
