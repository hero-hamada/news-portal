package com.epam.newsPortal.dao.Impl;

import com.epam.newsPortal.dao.NewsDAO;
import com.epam.newsPortal.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public NewsDAOImpl () {
    }

    public NewsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<News> list() {
        Session session = sessionFactory.openSession();
        List<News> newsList = (List<News>) session.createQuery("from News order by date", News.class).getResultList();
        return newsList;
    }

    @Override
    @Transactional
    public News get(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(News.class, id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Long id, News news) {
        sessionFactory.openSession().save(news);
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    @Transactional
    public void delete(List<Long> newsIds) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("DELETE news a WHERE id IN (:newsIds)", News.class);
        query.setParameter("newsIds", newsIds);
        query.executeUpdate();
//        sessionFactory.getCurrentSession().;
    }
}
