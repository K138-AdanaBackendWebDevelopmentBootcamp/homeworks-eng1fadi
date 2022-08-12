package de.patika.school_project.utils;

import de.patika.school_project.models.Course;
import de.patika.school_project.models.PermanentInstructor;
import de.patika.school_project.models.Student;
import de.patika.school_project.models.VisitingResearcher;
import de.patika.school_project.repository.CourseRepository;
import de.patika.school_project.repository.InstructorRepository;
import de.patika.school_project.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {
    private static final Logger logger= LoggerFactory.getLogger(InitializerRunner.class);
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        studentRepository.deleteAll();
        instructorRepository.deleteAll();
        courseRepository.deleteAll();

        Course c1=new Course("Geography","G22",45);
        Course c2=new Course("History","H654",45.0);
        Course c3=new Course("Music","M43",45);
        Course c4=new Course("Science","S76",45);

        VisitingResearcher v1=new VisitingResearcher("Taha","Izmir","5358687080",c1,566);
        VisitingResearcher v2=new VisitingResearcher("Victor","Mugla","5226510088",c3,1100);
        PermanentInstructor p1=new PermanentInstructor("Sadik","Bursa","5456670809",11844);

        Course course1=new Course();
        course1.setCcode("M211");
        course1.setCname("Math");
        course1.setInstructor(v1);
        course1.setCscore(54);
        course1.setStudents(null);
        Course course2=new Course();
        course2.setCcode("T777");
        course2.setCname("Turkish");
        course2.setInstructor(p1);
        course2.setCscore(76);
        course2.setStudents(null);
        Course course3=new Course();
        course3.setCcode("A53");
        course3.setCname("Art");
        course3.setInstructor(v2);
        course3.setCscore(63);
        course3.setStudents(null);

        Student s1=new Student("Fadi","Izmir","male", LocalDate.of(1990,3,4));
        Student s2=new Student("Mehmet","Adana","male",LocalDate.of(1993,5,24));
        Student s3=new Student("Omar","Izmir","male",LocalDate.of(1984,11,16));
        Student s4=new Student("Ezgi","Istanbul","female",LocalDate.of(1999,2,9));

        c1.setInstructor(v2);
        c2.setInstructor(v1);
        c3.setInstructor(v2);
        c4.setInstructor(p1);

        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);
        courseRepository.save(c4);
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
        studentRepository.save(s4);
        instructorRepository.save(v1);
        instructorRepository.save(v2);
        instructorRepository.save(p1);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        logger.info("All saved.............");
    }
}
