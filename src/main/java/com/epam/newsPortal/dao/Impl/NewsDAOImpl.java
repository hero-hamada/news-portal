package com.epam.newsPortal.dao.Impl;

import com.epam.newsPortal.dao.NewsDAO;
import com.epam.newsPortal.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link com.epam.newsPortal.dao.NewsDAO}
 *
 * @author Zhanakhmetova Merey
 * @version 1.0
 */

@Repository
public class NewsDAOImpl implements NewsDAO {

    private SessionFactory sessionFactory;

    public NewsDAOImpl () {
    }

    @Autowired
    public NewsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Get all records from news table as list of {@link com.epam.newsPortal.model.News} objects using HQL
     */
    @Override
    @Transactional
    public List<News> getAll() {
        Session session = sessionFactory.openSession();
        List<News> newsList = session.createNamedQuery("all_news_order_by_date", News.class).getResultList();
        session.close();
        return newsList;
    }

    @Override
    @Transactional
    public News getById(Long id) {
        Session session = sessionFactory.openSession();
        News news = session.get(News.class, id);
        session.close();
        return news;
    }

    @Override
    @Transactional
    public void save(News news) {
        Session session = sessionFactory.openSession();
        session.save(news);
        session.close();
    }

    @Override
    @Transactional
    public void update(News news) {
        Session session = this.sessionFactory.openSession();
        session.update(news);
        session.close();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session session = this.sessionFactory.openSession();
        session.delete(this.getById(id));
        session.close();
    }

}
