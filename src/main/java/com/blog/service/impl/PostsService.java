package com.blog.service.impl;

import com.blog.PageAndSort.Pageable;
import com.blog.dao.IPostsDAO;
import com.blog.model.Posts;
import com.blog.service.IPostsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class PostsService implements IPostsService {

    @Inject
    IPostsDAO postsDAO;

    @Override
    public List<Posts> fillAll(Pageable pageable) {
        return postsDAO.fillAll(pageable);
    }

    @Override
    public Long save(Posts posts) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        posts.setCreateDate(timestamp);
        return postsDAO.save(posts);
    }

    @Override
    public Posts fillById(Long id) {
        return postsDAO.fillById(id);
    }

    @Override
    public Integer getTotalItem() {
        return postsDAO.count();
    }
}
