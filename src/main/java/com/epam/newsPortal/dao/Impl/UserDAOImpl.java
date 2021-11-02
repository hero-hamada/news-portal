package com.epam.newsPortal.dao.Impl;

import com.epam.newsPortal.dao.UserDAO;
import com.epam.newsPortal.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl () {
    }

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    Criteria API
    @Override
    @Transactional
    public User findByUsername(String name) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<User> criteria = builder.createQuery( User.class );
        Root<User> root = criteria.from( User.class );
        criteria.select( root );
        criteria.where( builder.equal( root.get("name"), name ) );

        return session.createQuery( criteria ).getSingleResult();

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
