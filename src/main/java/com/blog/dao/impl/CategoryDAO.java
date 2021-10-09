package com.blog.dao.impl;

import com.blog.dao.ICategoryDAO;
import com.blog.mapper.CategoryMapper;
import com.blog.model.Category;

import javax.annotation.ManagedBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

    @Override
    public List<Category> fillAll() {
        String sql = "SELECT * FROM category";
        List<Category> result = new ArrayList<>();
        try {
            return query(sql, new CategoryMapper());
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Long save(Category category) {
        String sql = "INSERT INTO category(name, code) VALUES(?, ?)";
        try {
            return insert(sql, category.getName(), category.getCode());
        } catch (SQLException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void update(Category category) {
        Category categoryDB = fillById(category.getId());
        if (categoryDB != null) {
            String sql = "UPDATE category SET name = ?, code = ? WHERE id = ?";
            try {
                update(sql, category.getName(), category.getCode(), categoryDB.getId());
            } catch (SQLException e) {
                e.getMessage();
            } catch (ClassNotFoundException e) {
                e.getMessage();
            }
        }
    }

    @Override
    public Category fillById(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        try {
            return fillById(sql, new CategoryMapper(), id, new Category());
        } catch (SQLException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }
}
