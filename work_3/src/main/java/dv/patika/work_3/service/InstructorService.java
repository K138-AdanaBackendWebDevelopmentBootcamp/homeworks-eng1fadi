package dv.patika.work_3.service;

public interface InstructorService <Instructor> extends BaseService<Instructor>{
    Instructor findByPhoneNo(Long phone_no);
    void deleteByPhoneNo(Long phone_no);
    Instructor updateByPhoneNo(Instructor instructor,Long phone_no);
}
