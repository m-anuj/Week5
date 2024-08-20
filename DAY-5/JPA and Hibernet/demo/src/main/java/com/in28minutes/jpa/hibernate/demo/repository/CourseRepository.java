package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static java.sql.Types.NULL;

@Repository
@Transactional  //most imp for transactional operations
public class CourseRepository {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById (long id){
        return em.find(Course.class, id);
    }

    //public Course save (Course course) -> insert or update
    public Course save (Course course){
        if(course.getId()== NULL){
            //insert
            em.persist(course);
        }
        else{
            //update
            em.merge(course);
        }
        return course;
    }


    // public void deleteById (long id)
    public void deleteById(long id){
        Course course = findById(id); //get the course
        em.remove(course);  //remove the course
    }

    //playing with entity manager

    public void playWithEntityManager(){
        //persist: to create new resources
        Course course1 = new Course("web services in 100 steps");
        em.persist(course1);
        Course course2 = new Course("Angular js in 100 steps");
        em.persist(course2);

        em.flush();

        course1.setName("web services in 100 steps -  updated");
        course2.setName("Angular js in 100 steps -  updated");

        em.refresh(course1); //content of course 1 is refereshed to get the prev. content



    }


}
/*

By default em tracks everythings
if you dont want something to be tracked. do detach()

em.flush is for persisting the data in db
em.clear() is for clearing everything just like em.detach
 */