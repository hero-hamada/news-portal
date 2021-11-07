package com.epam.newsPortal.service;

import com.epam.newsPortal.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    List<NewsDTO> getAll();
    NewsDTO getById(Long id);
    void save(NewsDTO newsDTO);
    void update(NewsDTO newsDTO);
    void delete(Long id);
}
