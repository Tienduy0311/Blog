package com.blog.dao;

import com.blog.model.Category;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<Category> {
    List<Category> fillAll();

    Long save(Category category);

    void update(Category category);

    Category fillById(Long id);
}
