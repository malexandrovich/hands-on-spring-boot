package com.springproject.socialnetwork;

import com.springproject.socialnetwork.models.Course;
import com.springproject.socialnetwork.models.User;
import com.springproject.socialnetwork.repositories.CoursesRepository;
import com.springproject.socialnetwork.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Bean for filling the database with data.
	 *
	 * @param courseRepository - the course repository.
	 * @param userRepository - the user repository.
	 * @return CommandLineRunner.
	 */
	@Bean
	public CommandLineRunner demoData(CoursesRepository courseRepository, UserRepository userRepository) {
		return args -> {
			Course course1 = new Course();
			course1.setId(1L);
			course1.setTitle("Course 1");
			course1.setDescription("Course description");
			course1.setLink("http://localhost:8080");
			courseRepository.save(course1);

			Course course2 = new Course();
			course2.setId(2L);
			course2.setTitle("Course 2");
			course2.setDescription("Course description");
			course2.setLink("http://localhost:8080");
			courseRepository.save(course2);

			Course course3 = new Course();
			course3.setId(3L);
			course3.setTitle("Course 3");
			course3.setDescription("Course description");
			course3.setLink("http://localhost:8080");
			courseRepository.save(course3);

			User user1 = new User();
			user1.setUsername("user");
			user1.setPassword("pass");
			user1.setRole("ROLE_USER");
			userRepository.save(user1);
		};
	}
}
