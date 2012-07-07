package com.yourpackagename.yourwebproject.service.impl;

import com.yourpackagename.framework.data.BaseJpaServiceImpl;
import com.yourpackagename.framework.exception.database.NotFoundException;
import com.yourpackagename.framework.validation.EntityValidator;
import com.yourpackagename.framework.validation.Validity;
import com.yourpackagename.yourwebproject.common.Key;
import com.yourpackagename.yourwebproject.common.Message;
import com.yourpackagename.yourwebproject.model.entity.User;
import com.yourpackagename.yourwebproject.model.repository.UserRepository;
import com.yourpackagename.yourwebproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Service impl class to implement services for accessing the User object entity.
 * This class acts as an interface between the outer world and the UserRepository
 *
 * @author: Y Kamesh Rao
 * @created: 3/25/12 11:05 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Service
@Transactional
public class UserServiceImpl extends BaseJpaServiceImpl<User, Long> implements UserService {
    private @Autowired UserRepository userRepository;
    private @Autowired Message msg;
    private @Autowired Key key;


    @PostConstruct
    public void setupService() {
        this.baseJpaRepository = userRepository;
        this.entityClass = User.class;
        this.baseJpaRepository.setupEntityClass(User.class);
    }


    @Override public boolean isValidPass(User user, String pass) {
        return user.getPassWord().equals(User.hashPassword(pass));
    }


    @Override public User registerUser(User user, HttpServletRequest request) {
        user.setPassWord(User.hashPassword(user.getPassWord()));
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(0);
        return userRepository.insert(user);
    }


    @Override public User loginUser(final User user, final HttpServletRequest request) {
        user.setLastLoginAt(user.getCurrentLoginAt());
        user.setLastLoginIp(user.getCurrentLoginIp());
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(user.getLoginCount() + 1);
        user.setUpdatedAt(new Date());

        return userRepository.update(user);
    }


    @Override public boolean isUsernameExists(String username) {
        if (userRepository.findByUsername(username) != null) {
            return true;
        } else
            return false;
    }


    @Override public boolean isEmailExists(String email) {
        if (userRepository.findByEmail(email) != null) {
            return true;
        } else
            return false;
    }


    @Override public Validity validate(User user) {
        EntityValidator<User> entityValidator = new EntityValidator<User>();
        Validity validity = entityValidator.validate(user, User.class);

        // Check for username and email uniqueness
        if (isUsernameExists(user.getUserName())) {
            validity.addError(msg.userExists);
        }

        if (isEmailExists(user.getEmail())) {
            validity.addError(msg.emailExists);
        }

        return validity;
    }


    @Override public User findByUsername(String username) throws NotFoundException {
        User user = userRepository.findByUsername(username);

        if(user != null) {
            return user;
        } else {
            throw new NotFoundException(key.unfMsg, key.unfCode);
        }
    }
}
