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
     * Gets one record by username from users table as {@link com.epam.newsPortal.model.User} object
     * @param username {@link com.epam.newsPortal.model.User}.username
     * @return User object by passed username
     */
    User findByUsername(String username);

    /**
     * Saves one record to the users table
     * @param user {@link com.epam.newsPortal.model.User} object to save
     */
    void save(User user);

    /**
     * Get one record by id from users table as {@link com.epam.newsPortal.model.User} object
     * @param id primary key of {@link com.epam.newsPortal.model.User} object
     * @return {@link com.epam.newsPortal.model.User} object with passed id
     */
    User getById(Long id);
}
