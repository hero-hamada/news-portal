package com.epam.newsPortal.service.impl;

import com.epam.newsPortal.dao.NewsDAO;
import com.epam.newsPortal.dto.NewsDTO;
import com.epam.newsPortal.mapper.NewsMapper;
import com.epam.newsPortal.model.News;
import com.epam.newsPortal.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link com.epam.newsPortal.service.NewsService}
 *
 * @author Zhanakhmetova Merey
 * @version 1.0
 */

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private NewsMapper newsMapper;

    /**
     * Calls {@link com.epam.newsPortal.dao.NewsDAO} {@code getAll()} to get all News object
     * then calls {@link com.epam.newsPortal.mapper.NewsMapper} {@code entityListToDtoList()} method to map them
     * @return List of all {@link com.epam.newsPortal.dto.NewsDTO} objects
     * @see NewsDAO#getAll()
     * @see NewsMapper#entityListToDtoList(List)
     */
    @Override
    public List<NewsDTO> getAll() {
        return newsMapper.entityListToDtoList(newsDAO.getAll());
    }

    /**
     * Calls {@link com.epam.newsPortal.dao.NewsDAO} {@code getAll()} to get one News object
     * then refers this object to {@link com.epam.newsPortal.mapper.NewsMapper} {@code entityToDto(News)} method to map
     * @return {@link com.epam.newsPortal.dto.NewsDTO} object with the given id
     * @see NewsDAO#getById(Long)
     * @see NewsMapper#entityToDto(News)
     */
    @Override
    public NewsDTO getById(Long id) {
        return newsMapper.entityToDto(newsDAO.getById(id));
    }

    /**
     * Calls {@link com.epam.newsPortal.mapper.NewsMapper} {@code dtoToEntity(NewsDTO)} method to map
     * then refers this mapped object to {@link com.epam.newsPortal.dao.NewsDAO} {@code save()}
     * @see NewsDAO#save(News)
     * @see NewsMapper#dtoToEntity(NewsDTO)
     */
    @Override
    public void save(NewsDTO newsDTO) {
        newsDAO.save(newsMapper.dtoToEntity(newsDTO));
    }

    /**
     * Calls {@link com.epam.newsPortal.mapper.NewsMapper} {@code dtoToEntity(NewsDTO)} method to map
     * then refers this mapped object to {@link com.epam.newsPortal.dao.NewsDAO} {@code update()}
     * @see NewsDAO#update(News)
     * @see NewsMapper#dtoToEntity(NewsDTO)
     */
    @Override
    public void update(NewsDTO newsDTO) {
        newsDAO.update(newsMapper.dtoToEntity(newsDTO));
    }

    /**
     * Calls {@link com.epam.newsPortal.dao.NewsDAO} delete(id) with passed id
     * @see NewsDAO#delete(Long)
     */
    @Override
    public void delete(Long id) {
        newsDAO.delete(id);
    }
}
