package controller;

import pak2.Course;
import pak2.Instructor;
import pak2.Student;
import service.CourseService;

import java.util.List;

public class CourseController {
    CourseService courseService=new CourseService();
    public List<Course> listAllCourse(){
        return courseService.listAll();
    }
    public Course findById(int id){
        return courseService.finByID(id);
    }
    public void saveCourse(Course course){
        courseService.saveToDatabase(course);
    }
    public void updateCourse(Course course,int id){
        courseService.updateOnDatabase(course, id);
    }
    public void deleteCourse(Course course){
        courseService.deleteFromDatabase(course);
    }
    public void deleteCourse(int id){
        courseService.deleteFromDatabase(id);
    }
    public void deleteCourse(Long id){
        courseService.deleteByCourseId(id);
    }
    public Instructor getCourseInstructor(Course course){
        return courseService.getInstructor(course);
    }
    public List<Student> getCourseStudentList(Course course){
        return courseService.getStudent(course);
    }
}
