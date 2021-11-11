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
     * Get all records from news table as list of {@link com.epam.newsPortal.model.News} objects
     * @return List of all {@link com.epam.newsPortal.model.News} objects
     */
    List<News> getAll();

    /**
     * Get one record by id from news table as {@link com.epam.newsPortal.model.News} object
     * @param id primary key of {@link com.epam.newsPortal.model.News} object
     * @return {@link com.epam.newsPortal.model.News} object with passed id
     */
    News getById(Long id);

    /**
     * Saves one record to the news table
     * @param news {@link com.epam.newsPortal.model.News} object to save
     */
    @Transactional
    void save(News news);

    /**
     * Updates one record of news table by passed {@link com.epam.newsPortal.model.News} object
     * @param news {@link com.epam.newsPortal.model.News} object to update
     */
    @Transactional
    void update(News news);

    /**
     * Deletes one record from news table by passed id of {@link com.epam.newsPortal.model.News} object
     * @param id primary key of {@link com.epam.newsPortal.model.News} object
     */
    @Transactional
    void delete(Long id);
}
