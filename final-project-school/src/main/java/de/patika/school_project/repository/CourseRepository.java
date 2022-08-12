package de.patika.school_project.repository;

import de.patika.school_project.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {

    Course findCourseByCname(String cname);

    @Query("from Course c where c.id=?1")
    Course findCourse(int id);

    void deleteByCname(String cname);

    List<Course> findByCourseName(String cname);


}
