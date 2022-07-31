package dv.patika.work_3.controller;

import dv.patika.work_3.models.VisitingResearcher;
import dv.patika.work_3.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitingResearcherController implements InstructorControllerIm<VisitingResearcher> {
    private final InstructorService<VisitingResearcher> instructorService1;

    public VisitingResearcherController(InstructorService<VisitingResearcher> instructorService1) {
        this.instructorService1 = instructorService1;
    }

    @Override
    @GetMapping("/visiting_researchers")
    @Transactional
    public ResponseEntity<List<VisitingResearcher>> getAll() {
        return new ResponseEntity<>(instructorService1.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/visiting_researchers/{id}")
    @Transactional
    public ResponseEntity<VisitingResearcher> getById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService1.findById(id),HttpStatus.OK);
    }

    @Override
    @PutMapping ("/visiting_researchers/{id}")
    @Transactional
    public ResponseEntity<VisitingResearcher> updateById(VisitingResearcher instructor,@PathVariable int id) {
        return new ResponseEntity<>(instructorService1.update(instructor,id),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/visiting_researchers/{id}")
    @Transactional
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.ok("The researcher ("+id+") is deleted .......");
    }

    @Override
    @PostMapping("/visiting_researchers")
    @Transactional
    public ResponseEntity<VisitingResearcher> post(VisitingResearcher instructor) {
        return ResponseEntity.ok(instructorService1.save(instructor));
    }

    @Override
    @GetMapping("/visiting_researchers/{phone}")
    @Transactional
    public ResponseEntity<VisitingResearcher> getByPhoneNo(@PathVariable long phoneNo) {
        return new ResponseEntity<>(instructorService1.findByPhoneNo(phoneNo),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/visiting_researchers/{phone}")
    @Transactional
    public ResponseEntity<String> deleteByPhoneNo(@PathVariable long phoneNo) {
        instructorService1.deleteByPhoneNo(phoneNo);
        return ResponseEntity.ok("The researcher whose no is("+phoneNo+"), is deleted .......");
    }

    @Override
    @PutMapping ("/visiting_researchers/{phone}")
    @Transactional
    public ResponseEntity<VisitingResearcher> updateByPhoneNo(VisitingResearcher instructor, long phoneNo) {
        return new ResponseEntity<>(instructorService1.updateByPhoneNo(instructor,phoneNo),HttpStatus.OK);
    }
}
