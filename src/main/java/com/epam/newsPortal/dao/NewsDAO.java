package com.epam.newsPortal.dao;

import com.epam.newsPortal.model.News;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsDAO {
    List<News> getAll();

    News getById(Long id);

    @Transactional
    void save(News news);

    @Transactional
    void update(News news);

    @Transactional
    void delete(Long id);
}
