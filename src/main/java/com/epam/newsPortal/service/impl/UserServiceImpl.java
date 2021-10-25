package com.epam.newsPortal.service.impl;

import com.epam.newsPortal.dao.RoleDAO;
import com.epam.newsPortal.dao.UserDAO;
import com.epam.newsPortal.model.Role;
import com.epam.newsPortal.model.User;
import com.epam.newsPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.get(1L));
        user.setRole(roles);
        userDAO.save(user);
    }

    @Override
    public User findByName(String name) {
        return userDAO.findByName(name);
    }
}
