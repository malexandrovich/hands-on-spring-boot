package com.springproject.socialnetwork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException {

  private String message;

  public CourseNotFoundException() {}

  public CourseNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
