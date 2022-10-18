package com.springproject.socialnetwork.controller;

import com.springproject.socialnetwork.models.AuthenticationRequest;
import com.springproject.socialnetwork.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Authentication.
 */
@CrossOrigin
@RestController
public class AuthController {

  @Autowired
  private AuthService authService;

  /**
   * Post request to get Jwt token.
   *
   * @param authenticationRequest - username and password of the user.
   * @return jwt token.
   * @throws Exception - exception when authentication failed (bad credentials).
   */
  @PostMapping("/authenticate")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest
                                                         authenticationRequest) throws Exception {
    return authService.createAuthenticationToken(authenticationRequest);
  }
}
