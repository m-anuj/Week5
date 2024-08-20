package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class) //spring context
class JPQLTest {
	private Logger logger  = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
//	@Test
//	public void jpql_basic() {
//		List resultList1 = em.createQuery("select c from Course c").getResultList();
//		// logger.info("Select c from Course c -> {}",resultList);
//		printCourses(resultList1);
//	}
//
//
//	//typed Queries are always better, they provide type safety
//	@Test
//	public void jpql_typed() {
//		TypedQuery<Course> query =
//				em.createQuery("select c from Course c", Course.class);
//		List<Course> resultList = query.getResultList();
//		printCourses(resultList);
//	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> query =
				em.createQuery("select c from Course c where c.name like '%web services%'", Course.class);
		List<Course> resultList = query.getResultList();
		printCourses(resultList);
	}

	private void printCourses(List<Course> courses) {
		String format = "| %-4s | %-30s |\n";
		logger.info("+------+--------------------------------+\n");
		logger.info(String.format(format, "ID", "Name"));
		logger.info("+------+--------------------------------+\n");
		for (Course course : courses) {
			logger.info(String.format(format, course.getId(), course.getName()));
		}
		logger.info("+------+--------------------------------+\n");
	}



}
