package dv.patika.work_3.Dao;

import dv.patika.work_3.models.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class CourseDaoIm implements CourseDao<Course> {
    private final EntityManager entityManager;

    public CourseDaoIm(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Course> findAll() {
        return entityManager.createQuery("from Course",Course.class).getResultList();
    }

    @Override
    @Transactional
    public Course findById(int id) {
        return (Course) entityManager.createQuery("from Course i Where i.id=:idParam").setParameter("idParam",id).getSingleResult();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        //checkingObjectExistence(Course);
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Course fnd=entityManager.createQuery("from Course i Where i.id=:idParam",Course.class).getSingleResult();
        entityManager.remove(fnd);
    }

    @Override
    @Transactional
    public Course update(Course course, int id) {
        Course fnd=entityManager.createQuery("from Course i Where i.id=:idParam",Course.class).setParameter("idParam",id).getSingleResult();
        fnd.setCname(course.getCname());
        fnd.setCcode(course.getCcode());
        fnd.setInstructor(course.getInstructor());
        fnd.setStudents(course.getStudents());
        return entityManager.merge(fnd);
    }

    @Override
    @Transactional
    public void deleteByCode(String code) {
        Course fnd=entityManager.createQuery("from Course i Where i.code=:codeParam",Course.class).getSingleResult();
        entityManager.remove(fnd);

    }

    @Override
    @Transactional
    public Course updateByCode(Course course, String code) {
        Course fnd=entityManager.createQuery("from Course i Where i.code:codeParam",Course.class).setParameter("codeParam",code).getSingleResult();
        fnd.setCname(course.getCname());
        fnd.setCcode(course.getCcode());
        fnd.setInstructor(course.getInstructor());
        fnd.setStudents(course.getStudents());
        return entityManager.merge(fnd);
    }
    /////////////////////////////
}
