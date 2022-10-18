package com.springproject.socialnetwork.services;

import com.springproject.socialnetwork.dto.CreateCourseDto;
import com.springproject.socialnetwork.dto.UpdateCourseDto;
import com.springproject.socialnetwork.models.Course;
import java.util.List;
import java.util.Optional;

/**
 * Course Service interface.
 */
public interface CourseService {

  /**
   * Get all Courses.
   *
   * @return all Courses.
   */
  List<Course> getAllCourses();

  /**
   * Get one specific Course.
   * @param id - id of the Course.
   * @return Course.
   */
  Optional<Course> getSpecificCourse(Long id);

  /**
   * Create new Course.
   *
   * @param courseDto - data to create new Course.
   * @return new Course.
   */
  Course createCourse(CreateCourseDto courseDto);

  /**
   * Update a Course.
   *
   * @param courseId - id of the Course to update.
   * @param courseDto - data to update in the Course.
   * @return updated Course.
   */
  Course updateCourse(Long courseId, UpdateCourseDto courseDto);

  /**
   * Delete a Course.
   *
   * @param id - id of the Course to be deleted.
   */
  void deleteCourse(Long id);
}
