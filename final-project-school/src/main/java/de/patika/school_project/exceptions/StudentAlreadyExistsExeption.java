package de.patika.school_project.exceptions;

public class StudentAlreadyExistsExeption extends RuntimeException{
    public StudentAlreadyExistsExeption(String message){
        super(message);
    }
}
