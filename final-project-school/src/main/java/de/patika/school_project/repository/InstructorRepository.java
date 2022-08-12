package de.patika.school_project.repository;

import de.patika.school_project.models.Course;
import de.patika.school_project.models.Instructor;
import de.patika.school_project.models.PermanentInstructor;
import de.patika.school_project.models.VisitingResearcher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
    Instructor findInstructorByName(String name);

    @Query("from Instructor c where c.id=?1")
    Instructor findInstructor(int id);

    void deleteByName(String name);

    List<Instructor> findBySalaryIsGreaterThan(double salary);
    List<Instructor>findByNameContaining(String str);

}
