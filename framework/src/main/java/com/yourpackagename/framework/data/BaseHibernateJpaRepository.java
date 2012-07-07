package com.yourpackagename.framework.data;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author: Y Kamesh Rao
 * @created: 4/7/12 8:58 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public class BaseHibernateJpaRepository<T extends Entity, ID extends Serializable> implements BaseJpaRepository<T, ID> {
    protected @Autowired SessionFactory sessionFactory;
    protected Class<T> clazz;


    @Override
    @SuppressWarnings("unchecked")
    public void setupEntityClass(Class clazz) {
        this.clazz = clazz;
    }


    @Override
    public void delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
    }


    @Override
    @Transactional
    public T insert(T object) {
        sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
        sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().flush();
        return object;
    }


    @Override
    @Transactional
    public T update(T object) {
        sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
        sessionFactory.getCurrentSession().update(object);
        sessionFactory.getCurrentSession().flush();
        return object;
    }


    @Override
    @Transactional
    public T insertOrUpdate(T object) {
        sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
        sessionFactory.getCurrentSession().saveOrUpdate(object);
        sessionFactory.getCurrentSession().flush();
        return object;
    }


    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }


    @Override public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
        c.setMaxResults(countPerPage);
        c.setFirstResult(pageNum * countPerPage);
        return c.list();
    }
}
