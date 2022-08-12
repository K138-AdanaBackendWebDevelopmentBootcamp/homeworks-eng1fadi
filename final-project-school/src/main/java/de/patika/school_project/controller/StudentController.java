package de.patika.school_project.controller;

import de.patika.school_project.models.Course;
import de.patika.school_project.models.Student;
import de.patika.school_project.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student ("+id+") is deleted ......";
    }
    @DeleteMapping("/students/delete/{cname}")
    public String deleteStudentByName(@RequestBody String name){
        studentService.deleteByName(name);
        return "Student ("+name+") is deleted ......";
    }
}
