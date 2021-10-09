package com.blog.dao;

import com.blog.mapper.RowMapper;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> mapper, Object... parameter) throws SQLException, ClassNotFoundException;

    <T> List<T> query(String sql, RowMapper<T> mapper, List<Object> parameter) throws SQLException, ClassNotFoundException;

    Long insert(String sql, Object... parameter) throws SQLException, ClassNotFoundException;

    <T> T fillById(String sql, RowMapper<T> mapper, Long id, T model) throws SQLException, ClassNotFoundException;

    <T> T fillBy(String sql, RowMapper<T> mapper, T model, Object... parameter) throws SQLException, ClassNotFoundException;

    void update(String sql, Object... parameter) throws SQLException, ClassNotFoundException;

    Integer count(String sql) throws SQLException;
}
