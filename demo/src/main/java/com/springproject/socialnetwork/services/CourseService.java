package com.springproject.socialnetwork.services;

import com.springproject.socialnetwork.dto.CreateCourseDto;
import com.springproject.socialnetwork.dto.UpdateCourseDto;
import com.springproject.socialnetwork.models.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {

  List<Course> getAllCourses();

  Optional<Course> getSpecificCourse(Long id);

  Course createCourse(CreateCourseDto courseDto);

  Course updateCourse(Long courseId, UpdateCourseDto courseDto);

  void deleteCourse(Long id);
}
