package com.springproject.socialnetwork.repositories;

import com.springproject.socialnetwork.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Long> {
}
