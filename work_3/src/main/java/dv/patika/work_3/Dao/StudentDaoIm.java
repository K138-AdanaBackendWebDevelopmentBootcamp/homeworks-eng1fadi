package dv.patika.work_3.Dao;

import dv.patika.work_3.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class StudentDaoIm implements StudentDao<Student> {
    private final EntityManager entityManager;

    public StudentDaoIm(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return entityManager.createQuery("from Student",Student.class).getResultList();
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return entityManager.createQuery("from Student i Where i=:idParam",Student.class).setParameter("idParam",id).getSingleResult();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        //check(student);
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student fnd=entityManager.createQuery("from Student i Where i=:idParam",Student.class).setParameter("idParam",id).getSingleResult();
        entityManager.remove(fnd);

    }

    @Override
    @Transactional
    public Student update(Student student, int id) {
        Student fnd= (Student) entityManager.createQuery("from Student i Where i=:idParam").setParameter("idParam",id).getSingleResult();
        fnd.setName(student.getName());
        fnd.setAddress(student.getAddress());
        fnd.setBirthDate(student.getBirthDate());
        fnd.setStudentCourseList(student.getStudentCourseList());
        fnd.setGender(student.getGender());
        return null;
    }
    //////////////
}
