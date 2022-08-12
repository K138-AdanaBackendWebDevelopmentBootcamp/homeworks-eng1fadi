package de.patika.school_project.repository;

import de.patika.school_project.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    Student findStudentByName(String name);

    @Query("from Student c where c.id=?1")
    Student findStudentById(int id);

    void deleteByName(String name);
}
