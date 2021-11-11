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
     * @param id Role id
     * @return Role object by id using NamedNativeQuery
     */
    Role get(Long id);
}
