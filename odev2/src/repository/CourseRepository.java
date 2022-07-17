package repository;

import pak2.Course;
import pak2.Instructor;
import pak2.Student;

import java.util.List;

public interface CourseRepository {
    void deleteByCourseId(Long id);
    Instructor getInstructor(Course course);
    List<Student>getStudent(Course course);
}
