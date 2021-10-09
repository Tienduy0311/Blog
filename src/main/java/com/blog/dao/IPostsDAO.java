package com.blog.dao;

import com.blog.PageAndSort.Pageable;
import com.blog.model.Posts;

import java.util.List;

public interface IPostsDAO extends GenericDAO<Posts> {
    List<Posts> fillAll(Pageable pageable);

    Long save(Posts posts);

    Posts fillById(Long id);

    Integer count();
}
