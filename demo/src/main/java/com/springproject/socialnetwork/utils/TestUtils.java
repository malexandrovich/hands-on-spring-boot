package com.springproject.socialnetwork.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;

@Component
public class TestUtils {

  private final String path = "build/resources/test/expectedData";

  public String getContent(String path) throws Exception {
    return Files.readString(Paths.get(this.path + path));
  }

}
