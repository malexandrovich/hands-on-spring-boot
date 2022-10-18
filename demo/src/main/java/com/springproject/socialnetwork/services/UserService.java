package com.springproject.socialnetwork.services;

import com.springproject.socialnetwork.dto.UserDto;
import com.springproject.socialnetwork.models.User;
import java.util.List;

/**
 * User service interface.
 */
public interface UserService {

  /**
   * Getting all Users.
   *
   * @return List of all Users.
   */
  List<User> getAllUsers();

  /**
   * Get a specific User.
   *
   * @param id - id of the User to be found.
   * @return User.
   */
  User getOneUser(Long id);

  User createUser(UserDto userDto);
}
