package dv.patika.work_3.Dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> findAll();
    T findById(int id);
    T save(T object);
    void deleteById(int id);
    T update(T object,int id);
}

