package de.patika.school_project.exceptions;

public class StudentNotExistsExeption extends RuntimeException{
    public StudentNotExistsExeption(String message){
        super(message);
    }
}
