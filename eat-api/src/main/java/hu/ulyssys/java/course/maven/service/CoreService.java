package hu.ulyssys.java.course.maven.service;

import java.util.List;


public interface CoreService<T> {
    List<T> getAll();

    T findById(Long id);

    void add(T entity);

    void remove(T entity);

    void update(T entity);
}
