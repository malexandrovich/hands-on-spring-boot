package com.springproject.socialnetwork.dto;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseDto {

  @NotEmpty
  private String title;

  @NotEmpty
  private String description;

  @NotEmpty
  private String link;
}
