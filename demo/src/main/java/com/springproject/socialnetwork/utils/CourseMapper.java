package com.springproject.socialnetwork.utils;

import com.springproject.socialnetwork.dto.UpdateCourseDto;
import com.springproject.socialnetwork.models.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper to not set ignored values in dto to null values.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

  /**
   * Mapper for course dto updates.
   *
   * @param courseDto - the course dto.
   * @param course - Course.
   */
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateCourse(UpdateCourseDto courseDto, @MappingTarget Course course);

}
