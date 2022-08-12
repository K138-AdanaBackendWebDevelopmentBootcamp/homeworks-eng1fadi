package de.patika.school_project.services;

import de.patika.school_project.exceptions.CourseAlreadyExistsExeption;
import de.patika.school_project.exceptions.InstructorNotExistsExeption;
import de.patika.school_project.exceptions.StudentAlreadyExistsExeption;
import de.patika.school_project.exceptions.StudentNotExistsExeption;
import de.patika.school_project.models.Course;
import de.patika.school_project.models.Student;
import de.patika.school_project.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Transactional
    public Student getStudent(int id) {
        return studentRepository.findById(id).get();
    }

    @Transactional
    public Student saveStudent(Student student) {
        Student fndstudent=studentRepository.findStudentByName(student.getName());
        if (fndstudent!=null){
            throw new StudentAlreadyExistsExeption("Student is exist with name"+student.getName());
        }
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(int id) {
        Student fndSt=studentRepository.findStudentById(id);
        if (fndSt==null){
            throw new StudentNotExistsExeption("Student whose id=("+id+") is not found.....");
        }
        studentRepository.deleteById(id);
    }
    @Transactional
    public void deleteByName(String name) {
        Student fndSt=studentRepository.findStudentByName(name);
        if (fndSt==null){
            throw new StudentNotExistsExeption("Student ("+name+") is not found.....");
        }
        studentRepository.deleteByName(name);
    }
}
