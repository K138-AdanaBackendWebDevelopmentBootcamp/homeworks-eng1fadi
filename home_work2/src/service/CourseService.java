package service;

//import org.hibernate.boot.Metadata;
import models.Course;
import models.Instructor;
import models.Student;
//import repository.CourseRepository;
import repository.CourseRepository;
import repository.CrudRepository;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course>, CourseRepository {
    EntityManager em = HibernateUtil.buildSessionFactory();


    @Override
    public List<Course> listAll() {
        em.getTransaction().begin();
        List<Course>courseList=em.createQuery("from Course",Course.class).getResultList();
        return courseList;
    }
    @Override
    public Course findById(int id) {
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        return course;
    }
    @Override
    public void saveToDatabase(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        } finally {
            //HibernateUtil.closeEntityManager(em);
        }
    }
    public void updateOnDatabase(Course course, int id) {
        try {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    @Override
    public void deleteFromDatabase(Course course) {
        try {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();
            Course course=findById(id);
            em.remove(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }

    }

    @Override
    public void deleteByCourseId(int id) {
        try {
            em.getTransaction().begin();
            Course course = (Course) em.createQuery("FROM Course where courseId=:id", Course.class).setParameter("id", id).getSingleResult();
            em.getTransaction().rollback();
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
    }
    @Override
    public Instructor getInstructor(Course course) {
        try {
            em.getTransaction().begin();
            Course fndCourse = em.find(Course.class, course.getId());
            return fndCourse.getInstructor(null);
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }
    @Override
    public List<Student> getStudentList(Course course) {
        try {
            em.getTransaction().begin();
            Course fndCourse = em.find(Course.class, course.getId());
            return fndCourse.getStudents();
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }


}


