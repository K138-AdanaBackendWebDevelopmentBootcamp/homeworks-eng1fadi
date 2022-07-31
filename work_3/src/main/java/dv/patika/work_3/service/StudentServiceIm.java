package dv.patika.work_3.service;

import dv.patika.work_3.Dao.StudentDao;
import dv.patika.work_3.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceIm implements StudentService<Student> {
    private final StudentDao<Student> studentDao;

    public StudentServiceIm(StudentDao<Student> studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentDao.deleteById(id);

    }

    @Override
    public Student update(Student student, int id) {
        return studentDao.update(student,id);
    }
}
