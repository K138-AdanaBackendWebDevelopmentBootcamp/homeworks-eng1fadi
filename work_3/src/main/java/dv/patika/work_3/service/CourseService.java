package dv.patika.work_3.service;

public interface CourseService<Course> extends BaseService<Course> {
    void deleteByCode(String code);
    Course updateByCode(Course course,String code);
}
