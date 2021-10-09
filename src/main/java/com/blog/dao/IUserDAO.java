package com.blog.dao;

import com.blog.model.User;

import java.util.List;

public interface IUserDAO extends GenericDAO<User>{
    List<User> fillAll();

    User getAllByUserNamePassword(String userName, String password);
}
