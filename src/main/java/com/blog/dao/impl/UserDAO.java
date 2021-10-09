package com.blog.dao.impl;

import com.blog.dao.IUserDAO;
import com.blog.mapper.UserMapper;
import com.blog.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {
    @Override
    public List<User> fillAll() {
        String sql = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try {
            userList = query(sql, new UserMapper());
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        return userList;
    }

    @Override
    public User getAllByUserNamePassword(String userName, String password) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT * FROM users AS u ");
        sqlQuery.append("INNER JOIN roles AS r ");
        sqlQuery.append("ON u.roleid = r.id ");
        sqlQuery.append("WHERE u.username = ? AND u.password = ? AND u.status = 1");
        try {
            return fillBy(sqlQuery.toString(), new UserMapper(), new User(), userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }
}
