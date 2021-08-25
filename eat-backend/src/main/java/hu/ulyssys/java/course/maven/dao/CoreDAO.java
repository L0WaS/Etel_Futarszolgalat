package hu.ulyssys.java.course.maven.dao;
import java.util.List;

public interface CoreDAO<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T entity);

    T update(T entity);

    void delete(Long id);
}
