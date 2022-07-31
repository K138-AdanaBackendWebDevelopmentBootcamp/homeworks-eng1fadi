package dv.patika.work_3.Dao;

import javax.persistence.criteria.CriteriaBuilder;

public interface InstructorDao<Instructor> extends BaseDao<Instructor>{
    Instructor findByPhoneNo(Long phone_no);
    void deleteByPhoneNo(Long phone_no);
    Instructor updateByPhoneNo(Instructor instructor,Long phone_no);
}
