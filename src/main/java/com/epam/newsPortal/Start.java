//package com.epam.newsPortal;
//
//public class Start {

//    private static final Logger LOGGER = LoggerFactory.getLogger(NewsHelper.class.getName());

//    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        News news = ;
//        for (News news: new NewsHelper().getAuthorList()) {
////            System.out.println("news =" + news.toString());
//            LOGGER.info(news.getBrief());
//        }
//        News news1 = new NewsHelper().addNews(news);
//        HibernateConfig hibernateConfig = new HibernateConfig();
//        SessionFactory sessionFactory = (SessionFactory) hibernateConfig.sessionFactory();
//        NewsDAO newsDAO = new NewsDAOImpl(sessionFactory);
//        System.out.println(newsDAO.get(1L));
//        System.out.println();
//        NewsHelper news = new NewsHelper();
//        news.addNews(new News(22L, "Newssddd", LocalDate.now(), "Brief", "New content"));
//
//        for (int i = 0; i < 50; i++) {
//            news.addNews(new News("Newss " + i, LocalDate.now(), "Brief", "New content"));
//        }

//        HibernateUtil.getSessionFactory().close();
//    }
//}
