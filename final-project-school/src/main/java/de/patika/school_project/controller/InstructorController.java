package de.patika.school_project.controller;

import de.patika.school_project.models.Course;
import de.patika.school_project.models.Instructor;
import de.patika.school_project.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    @Autowired
    InstructorService instructorService;
    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors(){
        return instructorService.findAllInstructors();
    }
    @GetMapping("/instructors/{id}")
    public Instructor getInstructor(@PathVariable int id){
        return instructorService.getInstructor(id);
    }
    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return instructorService.saveInstructor(instructor);
    }
    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }
    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteInstructor(id);
        return "Instructor ("+id+") is deleted ......";
    }
    @DeleteMapping("/instructors/delete/{cname}")
    public String deleteInstructorByName(@RequestBody String name){
        instructorService.deleteByName(name);
        return "Instructor ("+name+") is deleted ......";
    }
    @GetMapping("/instructors/findBySalaryIsGreaterThan")
    List<Instructor>findBySalaryIsGreaterThan(double salary){
        return instructorService.findBySalaryIsGreaterThan(salary);
    }
    @GetMapping("/instructors/findByNameContaining")
    List<Instructor>findByNameContaining(String str){
        return instructorService.findByNameContaining(str);
    }


}
