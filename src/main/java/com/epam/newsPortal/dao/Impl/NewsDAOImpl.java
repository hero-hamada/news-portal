package com.epam.newsPortal.dao.Impl;

import com.epam.newsPortal.dao.NewsDAO;
import com.epam.newsPortal.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class NewsDAOImpl implements NewsDAO {

    private SessionFactory sessionFactory;


    public NewsDAOImpl () {
    }

    @Autowired
    public NewsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    HQL, JPQL
    @Override
    @Transactional
    public List<News> list() {
        Session session = sessionFactory.openSession();
        List<News> newsList = session.createNamedQuery("all_news_order_by_date", News.class).getResultList();
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
    public void save(News news) {
//        ????????saveOrUpdate
        Session session = sessionFactory.openSession();
        session.createQuery("insert into News (id, title, date, brief, content) from News").executeUpdate();

        session.save(news);
    }

    @Override
    @Transactional
    public void update(News news) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(news);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(get(id));
    }

}
