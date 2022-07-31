package dv.patika.work_3.Dao;

import dv.patika.work_3.models.Course;

public interface CourseDao<Course> extends BaseDao<Course> {
    void deleteByCode(String code);
    Course updateByCode(Course course,String code);
}
