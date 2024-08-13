package Spring_Jpa_RestAPI.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable long id) {

        return courseService.getCourseById(id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course) {

        courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course) {

        courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id) {

        courseService.deleteCourse(id);
    }
}
