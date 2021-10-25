package com.epam.newsPortal.dao.Impl;

import com.epam.newsPortal.dao.RoleDAO;
import com.epam.newsPortal.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    public RoleDAOImpl () {
    }

    @Autowired
    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role get(Long id) {
        return sessionFactory.openSession().get(Role.class, id);
    }
}
