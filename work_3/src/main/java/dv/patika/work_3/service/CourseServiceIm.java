package dv.patika.work_3.service;

import dv.patika.work_3.Dao.CourseDao;
import dv.patika.work_3.models.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceIm implements CourseService<Course> {
    private final CourseDao<Course> courseDao;

    public CourseServiceIm(CourseDao<Course> courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseDao.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);

    }

    @Override
    public Course update(Course course, int id) {
        return courseDao.update(course,id);
    }

    @Override
    public void deleteByCode(String code) {
        courseDao.deleteByCode(code);

    }

    @Override
    public Course updateByCode(Course course, String code) {
        return courseDao.updateByCode(course,code);
    }
}
