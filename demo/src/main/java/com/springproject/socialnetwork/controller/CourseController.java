package com.springproject.socialnetwork.controller;

import com.springproject.socialnetwork.dto.CreateCourseDto;
import com.springproject.socialnetwork.dto.UpdateCourseDto;
import com.springproject.socialnetwork.models.Course;
import com.springproject.socialnetwork.services.CourseService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for course entity.
 */
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

  private final CourseService courseService;

  /**
   * Getting all courses.
   *
   * @return All courses.
   */
  @GetMapping
  public List<Course> getAllCourses() {
    return courseService.getAllCourses();
  }

  /**
   * Finds course by id.
   *
   * @param id - the id of the course.
   * @return Course.
   */
  @GetMapping("{id}")
  public Optional<Course> getSpecificCourse(@PathVariable("id") Long id) {
    return courseService.getSpecificCourse(id);
  }

  /**
   * Creates Course entity.
   *
   * @param courseDto data transfer object for course entity.
   * @return created Course.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Course createCourse(@Valid @RequestBody CreateCourseDto courseDto) {
    return courseService.createCourse(courseDto);
  }

  /**
   * Updating the Course data.
   *
   * @param id - id of the Course to update.
   * @param courseDto - updated data.
   * @return updated Course entity.
   */
  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Course updateCourse(@PathVariable("id") Long id, @Valid @RequestBody UpdateCourseDto courseDto) {
    return courseService.updateCourse(id, courseDto);
  }

  /**
   * Delete a Course entity.
   *
   * @param id - id of the course to be deleted.
   */
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteCourse(@PathVariable("id") Long id) {
    courseService.deleteCourse(id);
  }

}
