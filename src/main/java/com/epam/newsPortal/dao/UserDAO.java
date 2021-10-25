package com.epam.newsPortal.dao;

import com.epam.newsPortal.model.User;

public interface UserDAO {
    User findByName(String name);
    void save(User user);
    User get(Long id);
}
