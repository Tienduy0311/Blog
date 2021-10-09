package com.blog.service.impl;

import com.blog.dao.ICategoryDAO;
import com.blog.model.Category;
import com.blog.service.ICategoryService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<Category> fillAll() {
        return categoryDAO.fillAll();
    }

    @Override
    public Long save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public Category fillById(Long id) {
        return categoryDAO.fillById(id);
    }
}
