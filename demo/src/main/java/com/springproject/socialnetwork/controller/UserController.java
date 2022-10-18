package com.springproject.socialnetwork.controller;

import com.springproject.socialnetwork.dto.UserDto;
import com.springproject.socialnetwork.models.User;
import com.springproject.socialnetwork.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Users.
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * Getting all Users.
   *
   * @return List of all Users.
   */
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  /**
   * Getting specific User.
   *
   * @param id - id of the user to find.
   * @return User.
   */
  @GetMapping("/users/{id}")
  public User getOneUser(@PathVariable(name="id") Long id) {
    return userService.getOneUser(id);
  }

  @PostMapping("/register")
  public User createUser(@RequestBody UserDto userDto) {
    return userService.createUser(userDto);
  }
}
