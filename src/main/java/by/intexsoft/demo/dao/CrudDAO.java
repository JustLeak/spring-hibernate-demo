package by.intexsoft.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public abstract class CrudDAO<T, K extends Serializable> implements ICrudDAO<T, K> {
    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public CrudDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Session openSession() {
        return sessionFactory.openSession();
    }

    @Override
    public T find(K id) {
        String hql = "FROM " + clazz.getName() + " c WHERE c.id = :id";
        Session session = openSession();
        Query<T> query = session.createQuery(hql, clazz);
        query.setParameter("id", id);
        T result = query.uniqueResult();
        session.close();
        return result;
    }

    @Override
    @Transactional
    public T create(T entity) {
        getCurrentSession().persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public T update(T entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }
}
