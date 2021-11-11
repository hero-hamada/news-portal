package com.epam.newsPortal.dao.Impl;

import com.epam.newsPortal.dao.RoleDAO;
import com.epam.newsPortal.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link com.epam.newsPortal.dao.RoleDAO}
 *
 * @author Zhanakhmetova Merey
 * @version 1.0
 */

@Repository
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    public RoleDAOImpl () {
    }

    @Autowired
    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Get one record by id from roles table as {@link com.epam.newsPortal.model.Role} object using NamedNativeQuery
     */
    @Override
    public Role getById(Long id) {
        Session session = sessionFactory.openSession();
        return session.createNamedQuery("get_role_by_id", Role.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
