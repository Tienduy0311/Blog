package com.blog.mapper;

import com.blog.model.Role;
import com.blog.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUserName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFullName(rs.getString("fullname"));
        user.setStatus(rs.getInt("status"));
        user.setRoleId(rs.getLong("roleid"));
        try {
            Role role = new Role();
            role.setName(rs.getString("name"));
            role.setCode(rs.getString("code"));
            user.setRole(role);
        } catch (Exception e) {
            e.getMessage();
        }
        return user;
    }
}
