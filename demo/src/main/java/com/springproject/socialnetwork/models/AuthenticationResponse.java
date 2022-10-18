package com.springproject.socialnetwork.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Authentication response model.
 */
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {

  private final String jwt;

}
