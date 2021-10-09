package com.blog.service;

import com.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> fillAll();

    Long save(Category category);

    void update(Category category);

    Category fillById(Long id);
}
