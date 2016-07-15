package com.aimprosoft.dao.implement;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 11.07.16.
 */
@Repository
public class GenericDao<T>  {

    @Autowired
    SessionFactory sessionFactory;

    public void saveOrUpdate(Object t) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(t);
    }

    public List<T> getAll(Class clazz) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public T getById(Class clazz, Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (T) session.get(clazz, id);

    }

    public void delete(Integer id, Class clazz) {
        Session session = sessionFactory.getCurrentSession();
        Object o = session.load(clazz, id);
        session.delete(o);
    }
}
