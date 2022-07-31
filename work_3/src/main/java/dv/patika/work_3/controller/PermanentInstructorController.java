package dv.patika.work_3.controller;

import dv.patika.work_3.models.PermanentInstructor;
import dv.patika.work_3.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class PermanentInstructorController implements InstructorControllerIm{
    private final InstructorService<PermanentInstructor> instructorService2;

    public PermanentInstructorController(InstructorService<PermanentInstructor> instructorService) {
        this.instructorService2 = instructorService;
    }

    @Override
    @GetMapping("/permanent_instructors")
    @Transactional
    public ResponseEntity<List<PermanentInstructor>> getAll() {
        return new ResponseEntity<>(instructorService2.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/permanent_instructors/{id}")
    @Transactional
    public ResponseEntity<PermanentInstructor> getById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService2.findById(id),HttpStatus.OK);
    }

    @PutMapping("/permanent_instructors/{id}")
    @Transactional
    public ResponseEntity<PermanentInstructor> updateById(PermanentInstructor instructor, @PathVariable int id) {
        return new ResponseEntity<>(instructorService2.update(instructor,id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        instructorService2.deleteById(id);
        return ResponseEntity.ok("The instructor ("+id+") is deleted .....");
    }



    @PostMapping("/permanent_instructors")
    public ResponseEntity<PermanentInstructor> post(PermanentInstructor instructor) {
        return ResponseEntity.ok(instructorService2.save(instructor));
    }

    @Override
    @GetMapping("/permanent_instructors/{phone}")
    @Transactional
    public ResponseEntity<PermanentInstructor> getByPhoneNo(long phoneNo) {
        return new ResponseEntity<>(instructorService2.findByPhoneNo(phoneNo),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/permanent_instructors/{phone}")
    @Transactional
    public ResponseEntity<String> deleteByPhoneNo(@PathVariable long phoneNo) {
        instructorService2.deleteByPhoneNo(phoneNo);
        return ResponseEntity.ok("The instructor whose phone no is ("+phoneNo+"), is deleted .....");
    }



    @PutMapping("/permanent_instructor/{phone}")
    @Transactional
    public ResponseEntity<PermanentInstructor> updateByPhoneNo(PermanentInstructor instructor, long phoneNo) {
        return new ResponseEntity<>(instructorService2.updateByPhoneNo(instructor,phoneNo),HttpStatus.OK);
    }
}
