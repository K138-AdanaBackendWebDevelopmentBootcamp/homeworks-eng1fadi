package service;

import org.hibernate.boot.Metadata;
import pak2.Course;
import pak2.Instructor;
import pak2.Student;
import repository.CourseRepository;
import repository.CrudRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course> , CourseRepository {
    private Metadata HibernateUtil;
    EntityManager em= (EntityManager) HibernateUtil.buildSessionFactory();
    @Override
    public void deleteByCourseId(Long id) {
        try {
            em.getTransaction().begin();
            //Course course= (Course) em.createQuery("from Course where courseId=:id,Course.class").setParameter("id",id).getSingleResult();
            em.getTransaction().rollback();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }

    }

    @Override
    public Instructor getInstructor(Course course) {
        try {
            em.getTransaction().begin();
            Course fndCourse=em.find(Course.class,course.getId());
            return fndCourse.getInstructor(null);
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Student> getStudent(Course course) {
        try {
            em.getTransaction().begin();
            Course fndCourse=em.find(Course.class,course.getId());
            return fndCourse.getStudentList();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Course> listAll() {
        em.getTransaction().begin();
        //List<Course>courseList=em.createQuery("from Course",Course.class).getResultList();

        return null;//courseList;
    }

    @Override
    public Course finByID(int id) {
        em.getTransaction().begin();
        Course course=em.find(Course.class,id);
        return course;
    }

    @Override
    public void saveToDatabase(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }finally {
           // HibernateUtil.closeEntityManager(em);
        }

    }

    @Override
    public void updateOnDatabase(Course course, int id) {
        try {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
        }

    }

    @Override
    public void deleteFromDatabase(Course course) {
        try {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }

    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();
            Course course=finByID(id);
            em.remove(course);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }

    }
}
