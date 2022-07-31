//import controller.CourseController;
import models.*;
import utils.HibernateUtil;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Testapp {
    public static void main(String[] args) {
        System.out.println("Let's start..............");

        EntityManager em= HibernateUtil.buildSessionFactory();

        Student s1=new Student("Fadi","Izmir","male",LocalDate.of(1990,3,4));
        Student s2=new Student("Mehmet","Adana","male",LocalDate.of(1993,5,24));
        Student s3=new Student("Omar","Izmir","male",LocalDate.of(1984,11,16));
        Student s4=new Student("Ezgi","Istanbul","female",LocalDate.of(1999,2,9));

        Course c1=new Course("Geography","G22",45);
        Course c2=new Course("History","H654",45);
        Course c3=new Course("Music","M43",45);
        Course c4=new Course("Science","S76",45);

        List<Course> cList1=new ArrayList<>();
        cList1.add(c1);
        cList1.add(c3);

        List<Course> cList2=new ArrayList<>();
        cList2.add(c2);
        List<Course> cList3=new ArrayList<>();
        cList3.add(c4);

        VisitingResearcher v1=new VisitingResearcher("Taha","Izmir","5358687080",cList1,566);
        VisitingResearcher v2=new VisitingResearcher("Victor","Mugla","5226510088",cList2,1100);
        PermanentInstructor p1=new PermanentInstructor("Sadik","Bursa","5456670809",cList3,11844);



        Course course1=new Course();
        course1.setCcode("M211");
        course1.setCname("Math");
        course1.setInstructor(v1);
        course1.setcScore(54);
        course1.setStudents(null);

        Course course2=new Course();
        course2.setCcode("T777");
        course2.setCname("Turkish");
        course2.setInstructor(p1);
        course2.setcScore(76);
        course2.setStudents(null);

        Course course3=new Course();
        course3.setCcode("A53");
        course3.setCname("Art");
        course3.setInstructor(v2);
        course3.setcScore(63);
        course3.setStudents(null);

        List<Course> courseList=new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        List<Student> sList=new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);

        c2.setStudents(sList);
        c1.setStudents(sList);
        c4.setStudents(sList);

        c1.setInstructor(v2);
        c2.setInstructor(v1);
        c3.setInstructor(v2);
        c4.setInstructor(p1);

        VisitingResearcher visitingResearcher1=new VisitingResearcher();
        visitingResearcher1.setAddress("Izmir");
        visitingResearcher1.setName("Kemal");
        visitingResearcher1.setPhoneNo("5232442123");
        visitingResearcher1.setCourseList(courseList);
        visitingResearcher1.sethSalary(6900);
        course1.setInstructor(visitingResearcher1);
        course2.setInstructor(visitingResearcher1);
        course3.setInstructor(visitingResearcher1);
/*
        CourseController courseController=new CourseController();
        courseController.saveCourse(course1);
        courseController.saveCourse(course2);
        courseController.saveCourse(course3);

        Course course7=courseController.findById(2);
        System.out.println(course7);
        //courseController.listAllCourse();
        //courseController.deleteCourse(c4);
        //courseController.getCourseStudentList(c2);
*/



        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        em.persist(s4);
        em.persist(v1);
        em.persist(v2);
        em.persist(p1);
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);
        em.persist(visitingResearcher1);
        em.getTransaction().commit();
        em.clear();
        em.close();

    }
}
