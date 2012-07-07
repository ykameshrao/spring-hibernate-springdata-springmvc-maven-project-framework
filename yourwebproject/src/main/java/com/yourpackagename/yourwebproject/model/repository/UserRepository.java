package com.yourpackagename.yourwebproject.model.repository;

import com.yourpackagename.framework.data.BaseJpaRepository;
import com.yourpackagename.yourwebproject.model.entity.User;

/**
 * DD Repository for User related actions and events
 * 
 * @author: Y Kamesh Rao
 * @created: 3/25/12 11:02 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public interface UserRepository extends BaseJpaRepository<User, Long> {
    /**
     * Finds a user with the given email
     *
     * @param email
     * @return
     */
    public User findByEmail(String email);


    /**
     * Finds a user with the given username
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
