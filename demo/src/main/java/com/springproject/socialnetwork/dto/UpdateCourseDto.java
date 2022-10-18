package com.springproject.socialnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for updating the course entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseDto {

  private String title;

  private String description;

  private String link;
}
