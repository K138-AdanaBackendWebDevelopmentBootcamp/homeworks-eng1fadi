package pak2.sec;
import controller.CourseController;
import org.hibernate.boot.Metadata;
import pak2.*;
import pak2.utils.EntityManagerUtils;
import java.lang.*;
import java.lang.ClassLoader;
import java.lang.Class;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestClient {
    public static void main(String[] args) {/*
        Student student1=new Student("Fadi","Izmir","male",LocalDate.of(1990,03,23));
        Student student2=new Student("Amir","Adana","male",LocalDate.of(1992,12,15));

        //Student student1=new Student("Fadi", "Izmir","male",LocalDate.of(1989,1,1));
        //Student student2=new Student("Amir", "Adana","male",LocalDate.of(1993,5,19));

        Course course1=new Course("Design","M221",22);
        Course course2=new Course("Materials","M3321",14);


        course1.getStudentList().add(student1);
        course2.getStudentList().add(student2);
        Instructor permanentInstructor=new PermanentInstructor("Ahmed","Izmir","53321212324",4000);
        Instructor visitingResearcher=new VisitingResearcher("Omar","Hatay","52233112121",6300);

        permanentInstructor.getCourseList().add(course1);
        visitingResearcher.getCourseList().add(course2);
        EntityManager em=EntityManagerUtils.getEntityManager("mysqlPU");


        try {
            em.getTransaction().begin();
            em.persist(student1);
            em.persist(student2);

            em.persist(course1);

            em.persist(course2);


            em.getTransaction().commit();
            System.out.println("donnn............");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }*/
        System.out.println("start...............");
        Metadata HibernateUtil = null;
        EntityManager em = (EntityManager) HibernateUtil.buildSessionFactory();
        Course course = new Course();
        course.setCname("Math");
        course.setCcode("M211");
        course.setcScore(21);
        course.setStudentList(null);
        course.getInstructor(null);

        Course course2 = new Course();
        course2.setCname("Math");
        course2.setCcode("M281");
        course2.setcScore(33);
        course2.setStudentList(null);
        course2.getInstructor(null);

        List<Course> courseList = new ArrayList<>();
        courseList.add(course);
        courseList.add(course2);
        VisitingResearcher visitingResearcher = new VisitingResearcher();
        visitingResearcher.sethSalary(12);

        visitingResearcher.setAddress("address");
        visitingResearcher.sethSalary(12);
        visitingResearcher.setPhoneNo("5343535453");

        course2.setInstructor(visitingResearcher);
        CourseController courseController = new CourseController();
        courseController.saveCourse(course);
        courseController.saveCourse(course2);


    }
}
