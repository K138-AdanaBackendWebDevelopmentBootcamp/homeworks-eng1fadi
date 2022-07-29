package pak2.sec;
import controller.CourseController;
//import org.hibernate.boot.Metadata;
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
    public static void main(String[] args) {
        saveData();
    }
       
    private static void saveData() {
            Student student1=new Student("Fadi","Izmir","male",LocalDate.of(1990,03,23));
            Student student2=new Student("Amir","Adana","male",LocalDate.of(1992,12,15));
            Course course1=new Course("Design","M221",22);
            Course course2=new Course("Materials","M3321",14);


            
            Instructor permanentInstructor=new PermanentInstructor("Ahmed","Izmir","53321212324",4000);
            Instructor visitingResearcher=new VisitingResearcher("Omar","Hatay","52233112121",6300);

            //permanentInstructor.getCourseList().add(course1);
            //visitingResearcher.getCourseList().add(course2);
            EntityManager em=EntityManagerUtils.getEntityManager("mysqlPU");

            permanentInstructor.setCourse(course1);
            visitingResearcher.setCourse(course2);
            student1.setCourse(course1);
            student2.setCourse(course2);
        
            Course course = new Course();
            course.setCname("Math");
            course.setCcode("M211");
            course.setcScore(21);
            course.setStudentList(null);
            course.getInstructor(null);

            course2.setInstructor(visitingResearcher);
            CourseController courseController = new CourseController();
            courseController.saveCourse(course);
            courseController.saveCourse(course2);


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


    }
        
        


    
}
