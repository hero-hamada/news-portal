package com.epam.newsPortal.mapper;

import com.epam.newsPortal.dto.NewsDTO;
import com.epam.newsPortal.model.News;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for {@link com.epam.newsPortal.model.News} and {@link com.epam.newsPortal.dto.NewsDTO}
 *
 * @author Merey Zhanakhmetova
 * @version 1.0
 */

@Mapper(componentModel = "spring")
public interface NewsMapper {

    /**
     * Mapping {@link com.epam.newsPortal.dto.NewsDTO} to {@link com.epam.newsPortal.model.News}
     * @param newsDTO {@link com.epam.newsPortal.dto.NewsDTO} object to map
     * @return mapped {@link com.epam.newsPortal.model.News} object from {@link com.epam.newsPortal.dto.NewsDTO} object
     */
    News dtoToEntity(NewsDTO newsDTO);

    /**
     * Mapping {@link com.epam.newsPortal.model.News} to {@link com.epam.newsPortal.dto.NewsDTO}
     * @param news {@link com.epam.newsPortal.model.News} object to map
     * @return mapped {@link com.epam.newsPortal.dto.NewsDTO} object from {@link com.epam.newsPortal.model.News} object
     */
    NewsDTO entityToDto(News news);

    /**
     * Mapping List of {@link com.epam.newsPortal.model.News} to List of {@link com.epam.newsPortal.dto.NewsDTO}
     * @param news List of {@link com.epam.newsPortal.model.News} objects to map
     * @return mapped List of {@link com.epam.newsPortal.dto.NewsDTO} objects
     */
    List<NewsDTO> entityListToDtoList(List<News> news);

    /**
     * Mapping List of {@link com.epam.newsPortal.dto.NewsDTO} to List of {@link com.epam.newsPortal.model.News}
     * @param newsDTO List of {@link com.epam.newsPortal.dto.NewsDTO} objects to map
     * @return mapped List of {@link com.epam.newsPortal.model.News} objects
     */
    List<News> dtoListToEntityList(List<NewsDTO> newsDTO);
}
