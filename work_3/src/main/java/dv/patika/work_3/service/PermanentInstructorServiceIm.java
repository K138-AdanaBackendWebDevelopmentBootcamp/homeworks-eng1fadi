package dv.patika.work_3.service;

import dv.patika.work_3.Dao.InstructorDao;
import dv.patika.work_3.models.PermanentInstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermanentInstructorServiceIm implements InstructorService<PermanentInstructor> {
    private final InstructorDao<PermanentInstructor> instructorDao;

    public PermanentInstructorServiceIm(InstructorDao<PermanentInstructor> instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        return instructorDao.findAll();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return instructorDao.findById(id);
    }

    @Override
    public PermanentInstructor save(PermanentInstructor instructor) {
        return instructorDao.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDao.deleteById(id);

    }

    @Override
    public PermanentInstructor update(PermanentInstructor instructor, int id) {
        return instructorDao.update(instructor,id);
    }

    @Override
    public PermanentInstructor findByPhoneNo(Long phone_no) {
        return instructorDao.findByPhoneNo(phone_no);
    }

    @Override
    public void deleteByPhoneNo(Long phone_no) {
        instructorDao.deleteByPhoneNo(phone_no);

    }

    @Override
    public PermanentInstructor updateByPhoneNo(PermanentInstructor instructor, Long phone_no) {
        return instructorDao.updateByPhoneNo(instructor,phone_no);
    }
}
