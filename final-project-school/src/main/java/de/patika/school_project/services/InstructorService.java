package de.patika.school_project.services;

import de.patika.school_project.exceptions.CourseNotExistsExeption;
import de.patika.school_project.exceptions.InstructorAlreadyExistsExeption;
import de.patika.school_project.exceptions.InstructorNotExistsExeption;
import de.patika.school_project.exceptions.StudentAlreadyExistsExeption;
import de.patika.school_project.models.Course;
import de.patika.school_project.models.Instructor;
import de.patika.school_project.models.Student;
import de.patika.school_project.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    InstructorRepository instructorRepository;

    @Transactional(readOnly = true)
    public List<Instructor> findAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Transactional
    public Instructor getInstructor(int id) {
        return instructorRepository.findById(id).get();
    }

    @Transactional
    public Instructor saveInstructor(Instructor instructor) {
        Instructor fndInstructor=instructorRepository.findInstructorByName(instructor.getName());
        if (fndInstructor!=null){
            throw new InstructorAlreadyExistsExeption("Instructor is exist with name"+instructor.getName());
        }
        return instructorRepository.save(instructor);
    }
    @Transactional
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Transactional
    public void deleteInstructor(int id) {
        Instructor fndI=instructorRepository.findInstructor(id);
        if (fndI==null){
            throw new InstructorNotExistsExeption("Instructor whose id=("+id+") is not found.....");
        }
        instructorRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        Instructor fndI=instructorRepository.findInstructorByName(name);
        if (fndI==null){
            throw new InstructorNotExistsExeption("Instructor ("+name+") is not found.....");
        }
        instructorRepository.deleteByName(name);
    }

    public List<Instructor> findBySalaryIsGreaterThan(double salary) {
        return instructorRepository.findBySalaryIsGreaterThan(salary);
    }

    public List<Instructor> findByNameContaining(String str) {
        return instructorRepository.findByNameContaining(str);
    }
}
