package com.epam.newsPortal.service;

import com.epam.newsPortal.dto.NewsDTO;

import java.util.List;

/**
 * Service class for {@link  com.epam.newsPortal.model.News}
 *
 * @author Zhanakhmetova Merey
 * @version 1.0
 */

public interface NewsService {

    /**
     * Gets all news as list of {@link com.epam.newsPortal.dto.NewsDTO} objects
     * @return List of all {@link com.epam.newsPortal.dto.NewsDTO} objects
     */
    List<NewsDTO> getAll();

    /**
     * @param id {@link com.epam.newsPortal.model.News}.id or {@link com.epam.newsPortal.dto.NewsDTO}.id
     * @return {@link com.epam.newsPortal.dto.NewsDTO} object with passed id
     */
    NewsDTO getById(Long id);

    /**
     * Saves by passed {@link com.epam.newsPortal.dto.NewsDTO} object
     * @param newsDTO {@link com.epam.newsPortal.dto.NewsDTO} object to save
     */
    void save(NewsDTO newsDTO);

    /**
     * Updates by passed {@link com.epam.newsPortal.dto.NewsDTO} object
     * @param newsDTO {@link com.epam.newsPortal.dto.NewsDTO} object to update
     */
    void update(NewsDTO newsDTO);

    /**
     * Deletes by passed id of {@link com.epam.newsPortal.dto.NewsDTO} object
     * @param id {@link com.epam.newsPortal.model.News}.id or {@link com.epam.newsPortal.dto.NewsDTO}.id
     */
    void delete(Long id);
}
