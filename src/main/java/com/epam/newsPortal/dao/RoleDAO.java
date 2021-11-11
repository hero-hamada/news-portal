package com.epam.newsPortal.dao;

import com.epam.newsPortal.model.Role;

/**
 * Data Access Object for {@link com.epam.newsPortal.model.Role}
 *
 * @author Merey Zhanakhmetova
 * @version 1.0
 */

public interface RoleDAO {

    /**
     * Get one record by id from roles table as {@link com.epam.newsPortal.model.Role} object
     * @param id {@link com.epam.newsPortal.model.Role}.id
     * @return {@link com.epam.newsPortal.model.Role} object with passed id
     */
    Role getById(Long id);
}
