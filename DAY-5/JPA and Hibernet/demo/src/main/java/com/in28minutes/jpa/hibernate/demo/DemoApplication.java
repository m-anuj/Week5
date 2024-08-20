package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	private Logger logger  = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//on startup this run method runs that is in commandLineRunner
	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001L);

		logger.info("course 10001 is-> {}", course);
		repository.save(new Course("microservices in 100 sec"));
		repository.playWithEntityManager();




	}
}
