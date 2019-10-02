package by.intexsoft.demo.dao;

import java.io.Serializable;

public interface ICrudDAO<T, K extends Serializable> {

    T find(K id);

    T create(T entity);

    T update(T entity);

    void delete(T entity);
}
