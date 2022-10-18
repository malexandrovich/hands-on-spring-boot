package com.springproject.socialnetwork.services;

import com.springproject.socialnetwork.models.AuthenticationRequest;
import org.springframework.http.ResponseEntity;

/**
 * Service for Authentication.
 */
public interface AuthService {

  /**
   * Creating an authentication token and return it.
   *
   * @param authenticationRequest - request body with username and password.
   * @return jwt token.
   * @throws Exception - bad credentials.
   */
  ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}
