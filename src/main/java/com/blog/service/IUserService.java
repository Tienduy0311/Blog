package com.blog.service;

import com.blog.model.User;

public interface IUserService {

    User getAllByUserNamePassword(String userName, String password);

}
