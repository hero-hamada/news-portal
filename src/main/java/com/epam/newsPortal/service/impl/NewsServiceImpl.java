package com.epam.newsPortal.service.impl;

import com.epam.newsPortal.dao.NewsDAO;
import com.epam.newsPortal.dto.NewsDTO;
import com.epam.newsPortal.mapper.NewsMapper;
import com.epam.newsPortal.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<NewsDTO> getAll() {
        return newsMapper.entityListToDtoList(newsDAO.getAll());
    }

    @Override
    public NewsDTO getById(Long id) {
        return newsMapper.entityToDto(newsDAO.getById(id));
    }

    @Override
    public void save(NewsDTO newsDTO) {
        newsDAO.save(newsMapper.dtoToEntity(newsDTO));
    }

    @Override
    public void update(NewsDTO newsDTO) {
        newsDAO.update(newsMapper.dtoToEntity(newsDTO));
    }

    @Override
    public void delete(Long id) {
        newsDAO.delete(id);
    }
}
