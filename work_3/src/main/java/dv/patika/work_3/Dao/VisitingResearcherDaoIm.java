package dv.patika.work_3.Dao;

import dv.patika.work_3.models.VisitingResearcher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class VisitingResearcherDaoIm implements InstructorDao<VisitingResearcher> {
    private final EntityManager entityManager;

    public VisitingResearcherDaoIm(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return entityManager.createQuery("from VisitingResearcher",VisitingResearcher.class).getResultList();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return entityManager.createQuery("from VisitingResearcher i Where i=:idParam",VisitingResearcher.class).setParameter("idParam",id).getSingleResult();
    }

    @Override
    public VisitingResearcher save(VisitingResearcher instructor) {
        //check(instructor);
        return entityManager.merge(instructor);
    }

    @Override
    public void deleteById(int id) {
        VisitingResearcher fnd=entityManager.createQuery("from VisitingResearcher i Where i=:idParam",VisitingResearcher.class).setParameter("idParam",id).getSingleResult();
        if (fnd!=null)
            entityManager.remove(fnd);

    }

    @Override
    public VisitingResearcher update(VisitingResearcher instructor, int id) {
        VisitingResearcher fnd=entityManager.createQuery("from VisitingResearcher i Where i=:idParam",VisitingResearcher.class).setParameter("idParam",id).getSingleResult();
        fnd.setName(instructor.getName());
        fnd.setAddress(instructor.getAddress());
        fnd.sethSalary(instructor.gethSalary());
        fnd.setCourseList(instructor.getCourseList());
        return entityManager.merge(fnd);
    }

    @Override
    public VisitingResearcher findByPhoneNo(Long phone_no) {
        return entityManager.createQuery("from VisitingResearcher i Where i=:phoneParam",VisitingResearcher.class).setParameter("phoneParam",phone_no).getSingleResult();
    }

    @Override
    public void deleteByPhoneNo(Long phone_no) {
        VisitingResearcher fnd=entityManager.createQuery("from VisitingResearcher i Where i=:phoneParam",VisitingResearcher.class).setParameter("phoneParam",phone_no).getSingleResult();
        if (fnd!=null)
            entityManager.remove(fnd);

    }

    @Override
    public VisitingResearcher updateByPhoneNo(VisitingResearcher visitingResearcher, Long phone_no) {
        VisitingResearcher fnd=entityManager.createQuery("from VisitingResearcher i Where i=:phoneParam",VisitingResearcher.class).setParameter("phoneParam",phone_no).getSingleResult();
        fnd.setName(visitingResearcher.getName());
        fnd.setAddress(visitingResearcher.getAddress());
        fnd.sethSalary(visitingResearcher.gethSalary());
        fnd.setCourseList(visitingResearcher.getCourseList());
        return entityManager.merge(fnd);
    }
    ///////////////////
}
