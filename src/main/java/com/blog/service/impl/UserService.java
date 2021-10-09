package com.blog.service.impl;

import com.blog.dao.IUserDAO;
import com.blog.model.User;
import com.blog.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {

    @Inject
    IUserDAO userDAO;

    @Override
    public User getAllByUserNamePassword(String userName, String password) {
        return userDAO.getAllByUserNamePassword(userName, password);
    }
}
