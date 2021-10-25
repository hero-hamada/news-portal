package com.epam.newsPortal.dao;

import com.epam.newsPortal.model.News;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsDAO {
    List<News> list();
    News get(Long id);
    void saveOrUpdate(Long id, News news);
    void delete(Long id);

    @Transactional
    void delete(List<Long> newsIds);
}
