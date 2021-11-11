package com.epam.newsPortal.dao;

import com.epam.newsPortal.model.User;

/**
 * Data Access Object for {@link com.epam.newsPortal.model.User}
 *
 * @author Merey Zhanakhmetova
 * @version 1.0
 */

public interface UserDAO {
    /**
     * @param name username
     * @return User object by username using Criteria API
     */
    User findByUsername(String name);
    void save(User user);
    User get(Long id);
}
