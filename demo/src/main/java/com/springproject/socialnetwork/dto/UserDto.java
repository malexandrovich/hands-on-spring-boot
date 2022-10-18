package com.springproject.socialnetwork.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Data transfer object for creating User entity.
 */
@RequiredArgsConstructor
@Getter
public class UserDto {

  private String username;

  private String password;

}
