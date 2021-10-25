package com.epam.newsPortal.dao.Impl;

import com.epam.newsPortal.dao.UserDAO;
import com.epam.newsPortal.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl () {
    }

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User u where u.name=:name");
        query.setParameter("name", name);
        return (User) query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void save(User user) {
        sessionFactory.openSession().save(user);
    }

    @Override
    public User get(Long id) {
        return sessionFactory.openSession().get(User.class, id);
    }
}
