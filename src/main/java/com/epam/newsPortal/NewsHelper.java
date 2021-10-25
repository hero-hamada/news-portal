//package com.epam.newsPortal;
//
//import com.epam.newsPortal.model.News;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//public class NewsHelper {
//    private SessionFactory sessionFactory;
//
//    public NewsHelper() {
//        sessionFactory = HibernateUtil.getSessionFactory();
//    }
//
//    public List<News> getAuthorList() {
//        Session session = sessionFactory.openSession();
////        session.get(News.class, 1L);
//
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
//        Root<News> root = criteriaQuery.from(News.class);
//        criteriaQuery.select(root);
//
//        Query query = session.createQuery(criteriaQuery);
//        List<News> newsList = query.getResultList();
//        session.close();
//        return newsList;
//    }
//
//    public News addNews(News news) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(news);
//        session.getTransaction().commit();
//        session.close();
//        return news;
//    }
//
//}
