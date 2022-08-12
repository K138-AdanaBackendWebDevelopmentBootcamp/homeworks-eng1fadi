package de.patika.school_project.services;

import de.patika.school_project.exceptions.CourseAlreadyExistsExeption;
import de.patika.school_project.exceptions.CourseNotExistsExeption;
import de.patika.school_project.models.Course;
import de.patika.school_project.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public List<Course> findAllCourses(){
        return (List<Course>) courseRepository.findAll();
    }
    @Transactional
    public Course getcourses(int id) {
        return courseRepository.findById(id).get();
    }

    @Transactional
    public Course saveCourse(Course course) {
        Course fndCourse=courseRepository.findCourseByCname(course.getCname());
        if (fndCourse!=null){
            throw new CourseAlreadyExistsExeption("Course is exist with name"+course.getCname());
        }
        return courseRepository.save(course);
    }

    @Transactional
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }


    @Transactional
    public void deleteCourse(int id) {
        Course fndC=courseRepository.findCourse(id);
        if (fndC==null){
            throw new CourseNotExistsExeption("Course whose id=("+id+") is not found.....");
        }
        courseRepository.deleteById(id);
    }

    @Transactional
    public void deleteByCname(String cname) {
        Course fndC=courseRepository.findCourseByCname(cname);
        if (fndC==null){
            throw new CourseNotExistsExeption("Course whose id=("+cname+") is not found.....");
        }
        courseRepository.deleteByCname(cname);
    }

    public List<Course> findByCourseName(String cname) {
        return courseRepository.findByCourseName(cname);
    }

}
