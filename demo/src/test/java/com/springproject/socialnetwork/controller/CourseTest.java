package com.springproject.socialnetwork.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproject.socialnetwork.dto.CreateCourseDto;
import com.springproject.socialnetwork.models.Course;
import com.springproject.socialnetwork.repositories.CoursesRepository;
import com.springproject.socialnetwork.utils.TestUtils;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Tests for Course controller.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
@RequiredArgsConstructor
public class CourseTest {

  @Autowired
  private TestUtils testUtils;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private CoursesRepository coursesRepository;

  private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

  @Test
  public void getAllCoursesPositiveTest() throws Exception {
//    Getting the response for getting all users.
    String response = (mockMvc.perform(
      get("/courses"))
      .andExpect(status().isOk())
      .andReturn().getResponse())
      .getContentAsString();

//    Getting the expected value.
    String expectedResponse = testUtils.getContent("/GetAllUsers.json");

//    Comparing the values.
    assertThat(response).isEqualTo(expectedResponse);
  }

  @Test
  public void getOneUserPositiveTest() throws Exception {
//    Find the course entity.
    Course course = coursesRepository.findAll().get(1);

//    Getting response for getting one user.
    String response = (mockMvc.perform(
      get("/courses/" + course.getId()))
      .andExpect(status().isOk()).andReturn().getResponse())
      .getContentAsString();

//    Getting the expected value.
    String expectedResponse = testUtils.getContent("/GetOneUser.json");

//    Comparing the values.
    assertThat(response).isEqualTo(expectedResponse);
  }

  @Test
  public void updateOneUserPositiveTest() throws Exception {

//    Creating the CourseDto to create Course.
    CreateCourseDto createCourseDto = new CreateCourseDto();
    createCourseDto.setTitle("Java Programmer from 0 to Hero!");
    createCourseDto.setDescription("You will learn everything about Java!");
    createCourseDto.setLink("http://vk.com");

//    Converting String to JSON.
    String dtoAsJson = MAPPER.writeValueAsString(createCourseDto);

//    Getting response from the creating user request.
    String response = (mockMvc.perform(
      post("/courses")
        .contentType(MediaType.APPLICATION_JSON)
        .content(dtoAsJson)).andExpect(status().isCreated())
      .andReturn().getResponse()).getContentAsString();

//    Getting the expected value.
    String expectedResponse = testUtils.getContent("/CreateUser.json");

//    Comparing the values.
    assertThat(response).isEqualTo(expectedResponse);
//    Checking that the repository has one item more.
    assertThat(coursesRepository.count()).isEqualTo(4);
  }

}
