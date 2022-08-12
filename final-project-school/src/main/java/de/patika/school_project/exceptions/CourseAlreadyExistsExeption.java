package de.patika.school_project.exceptions;

import de.patika.school_project.models.Course;

public class CourseAlreadyExistsExeption extends RuntimeException{
    public CourseAlreadyExistsExeption(String message){
        super(message);
    }
}
