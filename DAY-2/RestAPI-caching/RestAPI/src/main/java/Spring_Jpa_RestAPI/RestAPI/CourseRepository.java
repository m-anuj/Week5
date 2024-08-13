package Spring_Jpa_RestAPI.RestAPI;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
}
