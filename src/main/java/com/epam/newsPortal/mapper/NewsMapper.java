package com.epam.newsPortal.mapper;

import com.epam.newsPortal.dto.NewsDTO;
import com.epam.newsPortal.model.News;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for {@link com.epam.newsPortal.dao.NewsDAO} and {@link com.epam.newsPortal.dto.NewsDTO}
 *
 * @author Merey Zhanakhmetova
 * @version 1.0
 */

@Mapper(componentModel = "spring")
public interface NewsMapper {
    News dtoToEntity(NewsDTO newsDTO);
    NewsDTO entityToDto(News news);
    List<NewsDTO> entityListToDtoList(List<News> news);
    List<News> dtoListToEntityList(List<NewsDTO> newsDTO);
}
