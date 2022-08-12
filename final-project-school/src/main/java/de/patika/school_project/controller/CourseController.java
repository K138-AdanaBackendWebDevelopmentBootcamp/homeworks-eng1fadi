package de.patika.school_project.controller;

import de.patika.school_project.models.Course;
import de.patika.school_project.models.Instructor;
import de.patika.school_project.repository.CourseRepository;
import de.patika.school_project.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }
    @GetMapping("/courses/{id}")
    public Course getcourses(@PathVariable int id){
        return courseService.getcourses(id);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }
    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteCourse(id);
        return "Course ("+id+") is deleted ......";
    }
    @DeleteMapping("/courses/delete/{cname}")
    public String deleteCourseByname(@RequestBody String cname){
        courseService.deleteByCname(cname);
        return "Course ("+cname+") is deleted ......";
    }
    @GetMapping("/findByCourseName")
    List<Course>findByCourseName(String cname){
        return courseService.findByCourseName(cname);
    }


}
