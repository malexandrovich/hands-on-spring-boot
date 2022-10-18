package com.springproject.socialnetwork.services.impl;

import com.springproject.socialnetwork.dto.UserDto;
import com.springproject.socialnetwork.exceptions.UserNotFoundException;
import com.springproject.socialnetwork.models.User;
import com.springproject.socialnetwork.repositories.UserRepository;
import com.springproject.socialnetwork.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for User entity.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  /**
   * Get the list of all Users.
   *
   * @return all Users.
   */
  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  /**
   * Get a specific User by id.
   *
   * @param id - id of the User to be found.
   * @return User.
   */
  @Override
  public User getOneUser(Long id) {
    return userRepository.findById(id)
      .orElseThrow(() -> new UserNotFoundException("User " + id + " does not exist"));
  }

  /**
   * Create a new user.
   *
   * @param userDto - the data to create new User.
   * @return new User.
   */
  @Override
  public User createUser(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    user.setRole("ROLE_USER");
    userRepository.save(user);
    return user;
  }
}
