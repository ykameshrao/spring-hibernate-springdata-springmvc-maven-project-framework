package com.yourpackagename.yourwebproject.model.repository.impl;

import com.yourpackagename.framework.data.BaseHibernateJpaRepository;
import com.yourpackagename.yourwebproject.model.entity.User;
import com.yourpackagename.yourwebproject.model.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository implementation
 *
 * @author: Y Kamesh Rao
 * @created: 3/26/12 8:30 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Repository
public class UserRepositoryImpl extends BaseHibernateJpaRepository<User, Long> implements UserRepository {

    @Override public User findByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.email = ?").setString(0,
                email).uniqueResult();
    }


    @Override public User findByUsername(String username) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.userName = ?").setString(0,
                username).uniqueResult();
    }
}
