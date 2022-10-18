package com.springproject.socialnetwork.services.impl;

import com.springproject.socialnetwork.dto.CreateCourseDto;
import com.springproject.socialnetwork.dto.UpdateCourseDto;
import com.springproject.socialnetwork.exceptions.CourseNotFoundException;
import com.springproject.socialnetwork.models.Course;
import com.springproject.socialnetwork.repositories.CoursesRepository;
import com.springproject.socialnetwork.services.CourseService;
import com.springproject.socialnetwork.utils.CourseMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Service for Course entity.
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CoursesRepository coursesRepository;
  private final CourseMapper courseMapper;

  /**
   * Finds all courses.
   *
   * @return All Courses as a list.
   */
  @Override
  public List<Course> getAllCourses() {
    return coursesRepository.findAll();
  }

  /**
   * Finds course by id.
   *
   * @param id the id of course.
   * @return Course.
   */
  @Override
  public Optional<Course> getSpecificCourse(Long id) {
    return coursesRepository.findById(id);
  }

  /**
   * Creates a new course entity.
   *
   * @param courseDto Dto to take parameters to create course.
   * @return new course entity.
   */
  @Override
  public Course createCourse(CreateCourseDto courseDto) {

//    get data from dto.
    String title = courseDto.getTitle();
    String description = courseDto.getDescription();
    String link = courseDto.getLink();

//    create new course object.
    Course course = new Course();
    course.setTitle(title);
    course.setDescription(description);
    course.setLink(link);

//    save new course and return it.
    return coursesRepository.save(course);
  }

  /**
   * Updating Course entity.
   *
   * @param courseId - the id of course to be updated.
   * @param courseDto - data to be updated.
   * @return updated course entity.
   */
  @Override
  public Course updateCourse(Long courseId, UpdateCourseDto courseDto) {

//    Getting course or throwing an exception "Not found".
    final Course course = coursesRepository.findById(courseId)
      .orElseThrow(() -> new CourseNotFoundException("Course not found"));

//    Updating the entity data.
    courseMapper.updateCourse(courseDto, course);
    coursesRepository.save(course);

//    Saving updated entity.
    return coursesRepository.save(course);
  }

  @Override
  public void deleteCourse(Long id) {
//    Getting the course to be deleted.
    Course course = coursesRepository.findById(id)
      .orElseThrow(() -> new CourseNotFoundException("Course not found"));

//    Delete the course.
    coursesRepository.delete(course);

  }
}
