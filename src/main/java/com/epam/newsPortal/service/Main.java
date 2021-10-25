package com.epam.newsPortal.service;

import com.epam.newsPortal.dao.Impl.NewsDAOImpl;
import com.epam.newsPortal.dao.NewsDAO;
import com.epam.newsPortal.model.News;

import java.time.LocalDate;

public class Main {

    private static NewsDAO newsDAO = new NewsDAOImpl();

    public static void main(String[] args) {
        News news = new News(1L,"d", LocalDate.MIN, "c", "d");
        System.out.println(news.getId());
    }
}
