package com.springproject.socialnetwork.utils;

import com.springproject.socialnetwork.dto.UpdateCourseDto;
import com.springproject.socialnetwork.models.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateCourse(UpdateCourseDto courseDto, @MappingTarget Course course);
}
