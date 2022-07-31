package dv.patika.work_3.controller;

import dv.patika.work_3.models.PermanentInstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface InstructorControllerIm <Instructor>extends BaseContollerIm<Instructor>{


    ResponseEntity<Instructor> getByPhoneNo(long phone);
    ResponseEntity<String> deleteByPhoneNo(long phone);
    ResponseEntity<Instructor> updateByPhoneNo(Instructor instructor,long phone);

}
