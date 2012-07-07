package com.yourpackagename.yourwebproject.service;

import com.yourpackagename.framework.data.BaseService;
import com.yourpackagename.framework.exception.database.NotFoundException;
import com.yourpackagename.yourwebproject.model.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Service class to have business logic operation on User entity
 *
 * @author: Y Kamesh Rao
 * @created: 3/24/12 3:51 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public interface UserService extends BaseService<User, Long> {

    /**
     * Register a new user into the system
     *
     * @param user
     * @param request
     *
     * @return
     */
    public User registerUser(User user, HttpServletRequest request);


    /**
     * Login a new user into the system
     *
     * @param user
     * @param request
     *
     * @return
     */
    public User loginUser(User user, HttpServletRequest request);

    /**
     * Method to validate whether the given password
     * is same as users password stored in the system
     *
     * @param user
     * @param pass
     *
     * @return
     */
    public boolean isValidPass(User user, String pass);


    /**
     * Validates whether the given username already
     * exists in the system.
     *
     * @param username
     *
     * @return
     */
    public boolean isUsernameExists(String username);


    /**
     * Validates whether the given email already
     * exists in the system.
     *
     * @param email
     *
     * @return
     */
    public boolean isEmailExists(String email);


    /**
     * Finds a user entity by the given username
     *
     * @param username
     * @return
     */
    public User findByUsername(String username) throws NotFoundException;
}
