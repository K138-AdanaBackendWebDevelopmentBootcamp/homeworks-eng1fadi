package repository;

import models.Course;

import java.util.List;

public interface CrudRepository<T> {


    List<Course> listAll();

    T findById(int id);
    void saveToDatabase(T object);

    void updateOnDatabase(Course course, int id);
    void deleteFromDatabase(Course course);
    void deleteFromDatabase(int id);
}
