package Spring_Jpa_RestAPI.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    private final static Logger logger = Logger.getLogger(String.valueOf(CourseService.class));

    @Cacheable(cacheNames="courses")
    public List<Course> getAllCourses() {
        logger.info("Fetching all courses from the database");
        return repository.findAll();
    }

    @Cacheable(cacheNames="course", key="#id")
    public Course getCourseById(long id) {
        logger.info("Fetching course from the database based on id");
        Optional<Course> course = repository.findById(id);
        if (course.isEmpty()) {
            throw new RuntimeException("Course not found with id: " + id);
        }
        return course.get();
    }

    @CachePut(cacheNames="courseAdd")
    public void addCourse(Course course) {
        logger.info("Adding course to the database");
        repository.save(course);
    }

    @CachePut(cacheNames="coursePut", key="#id")
    public void updateCourse(long id, Course course) {
        logger.info("Updating course details in the database");
        repository.save(course);
    }

    @CacheEvict(cacheNames="courseDelete", key="#id")
    public void deleteCourse(long id) {
        logger.info("Deleting course from the database");
        repository.deleteById(id);
    }

}
