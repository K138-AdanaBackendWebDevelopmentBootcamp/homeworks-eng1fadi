package de.patika.school_project.exceptions;

public class CourseNotExistsExeption extends RuntimeException{
    public CourseNotExistsExeption(String message){
        super(message);
    }
}
