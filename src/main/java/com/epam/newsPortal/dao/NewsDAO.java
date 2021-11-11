package com.epam.newsPortal.dao;

import com.epam.newsPortal.model.News;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Data Access Object for {@link com.epam.newsPortal.model.News}
 *
 * @author Merey Zhanakhmetova
 * @version 1.0
 */

public interface NewsDAO {
    /**
     * @return List of all News objects using HQL
     */
    List<News> getAll();

    News getById(Long id);

    @Transactional
    void save(News news);

    @Transactional
    void update(News news);

    @Transactional
    void delete(Long id);
}
