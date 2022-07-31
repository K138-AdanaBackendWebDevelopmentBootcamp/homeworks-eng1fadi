package dv.patika.work_3.controller;

import dv.patika.work_3.models.Student;
import dv.patika.work_3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController implements BaseContollerIm<Student> {
    private final StudentService<Student> studentService;

    @Autowired
    public StudentController(StudentService<Student> studentService) {
        this.studentService = studentService;
    }

    @Override
    @GetMapping("/students")
    @Transactional
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.findAll(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/students/{id}")
    @Transactional
    public ResponseEntity<Student> getById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @Override
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateById(@RequestBody Student student,@PathVariable int id) {
        return new ResponseEntity<>(studentService.update(student,id),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        studentService.deleteById(id);
        return new ResponseEntity<>("Student ("+id+") is deleted",HttpStatus.OK);
    }

    @Override
    @PostMapping("/students")
    public ResponseEntity<Student> post(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }
}
