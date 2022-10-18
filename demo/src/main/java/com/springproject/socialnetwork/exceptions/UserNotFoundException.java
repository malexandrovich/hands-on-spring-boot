package com.springproject.socialnetwork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for case if the User will be not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

  private String message;

  public UserNotFoundException() {}

  public UserNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
