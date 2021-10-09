package com.blog.service;

import com.blog.PageAndSort.Pageable;
import com.blog.model.Posts;

import java.util.List;

public interface IPostsService {
    List<Posts> fillAll(Pageable pageable);

    Long save(Posts posts);

    Posts fillById(Long id);

    Integer getTotalItem();
}
