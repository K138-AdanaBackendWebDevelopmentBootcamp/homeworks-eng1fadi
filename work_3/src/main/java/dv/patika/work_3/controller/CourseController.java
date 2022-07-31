package dv.patika.work_3.controller;

import dv.patika.work_3.models.Course;
import dv.patika.work_3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CourseController implements BaseContollerIm<Course> {
    private final CourseService<Course> courseService;

    @Autowired
    public CourseController(CourseService<Course> courseService) {
        this.courseService = courseService;
    }

    @Override
    @GetMapping("/courses")
    @Transactional
    public ResponseEntity<List<Course>> getAll() {
        return new ResponseEntity<>(courseService.findAll(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/courses/{id}")
    @Transactional
    public ResponseEntity<Course> getById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }

    @Override
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateById(@RequestBody Course course,@PathVariable int id) {
        return new ResponseEntity<>(courseService.update(course,id),HttpStatus.OK);
    }
    @PutMapping("/courses/{code}")
    public ResponseEntity<Course> updateByCode(@PathVariable String code,@RequestBody Course course) {
        return new ResponseEntity<>(courseService.updateByCode(course,code),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        courseService.deleteById(id);
        return new ResponseEntity<>("Course ("+id+") is deleted ............",HttpStatus.OK);
    }

    @Override
    @PostMapping("/courses")
    public ResponseEntity<Course> post(Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }
    @DeleteMapping("/courses/{code}")
    public ResponseEntity<String> deleteByCode(@PathVariable String code) {
        courseService.deleteByCode(code);
        return new ResponseEntity<>("Course ("+code+") is deleted ............",HttpStatus.OK);
    }
}
