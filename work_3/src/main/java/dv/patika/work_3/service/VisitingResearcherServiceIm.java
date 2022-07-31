package dv.patika.work_3.service;

import dv.patika.work_3.Dao.InstructorDao;
import dv.patika.work_3.models.VisitingResearcher;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisitingResearcherServiceIm implements InstructorService<VisitingResearcher> {
    private final InstructorDao<VisitingResearcher>instructorDao;

    public VisitingResearcherServiceIm(InstructorDao<VisitingResearcher> instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return instructorDao.findAll();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return instructorDao.findById(id);
    }

    @Override
    public VisitingResearcher save(VisitingResearcher instructor) {
        return instructorDao.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDao.deleteById(id);

    }

    @Override
    public VisitingResearcher update(VisitingResearcher instructor, int id) {
        return instructorDao.update(instructor,id);
    }

    @Override
    public VisitingResearcher findByPhoneNo(Long phone_no) {
        return instructorDao.findByPhoneNo(phone_no);
    }

    @Override
    public void deleteByPhoneNo(Long phone_no) {
        instructorDao.deleteByPhoneNo(phone_no);

    }

    @Override
    public VisitingResearcher updateByPhoneNo(VisitingResearcher visitingResearcher, Long phone_no) {
        return instructorDao.updateByPhoneNo(visitingResearcher,phone_no);
    }
}
