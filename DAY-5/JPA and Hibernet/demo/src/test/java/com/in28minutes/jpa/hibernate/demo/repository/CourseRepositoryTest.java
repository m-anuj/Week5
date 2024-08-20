package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class) //spring context
class CourseRepositoryTest {
	private Logger logger  = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	@Test
	public void findById_basicTestCase() {
		Course course  = repository.findById(10001L);
		assertEquals("JPA in 50", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basicTestCase(){
		repository.deleteById(10009L);
		assertNull(repository.findById(10009L)); //to check if this id is null
	}

	@Test
	@DirtiesContext
	public void save_basic(){
		//get a course
		Course course =  repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());

		//update details:
		course.setName("JPA in 50 steps- updated");
		repository.save(course);

		//check the value
		Course course1 =  repository.findById(10001L);
		assertEquals("JPA in 50 steps- updated", course1.getName());

	}
	@Test
	@DirtiesContext
	public void playWithEntityManagerTest(){
		repository.playWithEntityManager();
	}

}
