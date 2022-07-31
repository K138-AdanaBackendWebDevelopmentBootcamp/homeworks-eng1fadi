package dv.patika.work_3.Dao;

import dv.patika.work_3.models.PermanentInstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class PermanentDaoIm implements InstructorDao<PermanentInstructor> {
    private final EntityManager entityManager;

    public PermanentDaoIm(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        return entityManager.createQuery("from PermanentInstructor", PermanentInstructor.class).getResultList();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return entityManager.createQuery("from PermanentInstructor i Where i.id=:idParam",PermanentInstructor.class).setParameter("idParam",id).getSingleResult();
    }

    @Override
    public PermanentInstructor save(PermanentInstructor instructor) {
        //check(instructor);
        return entityManager.merge(instructor);
    }

    @Override
    public void deleteById(int id) {
        PermanentInstructor fnd=entityManager.createQuery("from PermanentInstructor i Where i.id=:idParam",PermanentInstructor.class).setParameter("idParam",id).getSingleResult();
        if (fnd!=null)
            entityManager.remove(fnd);
    }

    @Override
    public PermanentInstructor update(PermanentInstructor instructor, int id) {
        PermanentInstructor fnd=entityManager.createQuery("from PermanentInstructor i Where i.id=:idParam",PermanentInstructor.class).setParameter("idParam",id).getSingleResult();
        fnd.setName(instructor.getName());
        fnd.setAddress(instructor.getAddress());
        fnd.setCourseList(instructor.getCourseList());
        fnd.setfSalary(instructor.getfSalary());
        return entityManager.merge(fnd);

    }

    @Override
    public PermanentInstructor findByPhoneNo(Long phone_no) {
        return entityManager.createQuery("from PermanentInstructor i Where i.phone_no=:phoneParam",PermanentInstructor.class).setParameter("phoneParam",phone_no).getSingleResult();
    }

    @Override
    public void deleteByPhoneNo(Long phone_no) {
        PermanentInstructor fnd=entityManager.createQuery("from PermanentInstructor i Where i.phone_no=:phoneParam",PermanentInstructor.class).setParameter("phoneParam",phone_no).getSingleResult();
        if (fnd!=null)
            entityManager.remove(fnd);

    }

    @Override
    public PermanentInstructor updateByPhoneNo(PermanentInstructor instructor, Long phone_no) {
        PermanentInstructor fnd=entityManager.createQuery("from PermanentInstructor i Where i.phone_no=:phoneParam",PermanentInstructor.class).setParameter("phoneParam",phone_no).getSingleResult();
        fnd.setName(instructor.getName());
        fnd.setAddress(instructor.getAddress());
        fnd.setCourseList(instructor.getCourseList());
        fnd.setfSalary(instructor.getfSalary());
        return entityManager.merge(fnd);
    }
    ////////////////////////////
}
