package com.epam.newsPortal.mapper;

import com.epam.newsPortal.dto.NewsDTO;
import com.epam.newsPortal.model.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    News dtoToEntity(NewsDTO newsDTO);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "brief", target = "brief")
    @Mapping(source = "content", target = "content")
    NewsDTO entityToDto(News news);
    List<NewsDTO> entityListToDtoList(List<News> news);
    List<News> dtoListToEntityList(List<NewsDTO> newsDTO);
}
