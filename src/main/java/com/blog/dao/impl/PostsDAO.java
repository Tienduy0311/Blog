package com.blog.dao.impl;

import com.blog.PageAndSort.Pageable;
import com.blog.dao.IPostsDAO;
import com.blog.mapper.PostsMapper;
import com.blog.model.Posts;

import java.sql.SQLException;
import java.util.List;

public class PostsDAO extends AbstractDAO<Posts> implements IPostsDAO {

    @Override
    public List<Posts> fillAll(Pageable pageable) {
        StringBuilder sqlQuery = new StringBuilder();

        sqlQuery.append("SELECT * FROM posts ");
        if (pageable.getSortedBy().getSortName() != null && pageable.getSortedBy().getSortAscDec() != null) {
            sqlQuery.append("ORDER BY " + pageable.getSortedBy().getSortName() + " " + pageable.getSortedBy().getSortAscDec() + " ");
        }
        if (pageable.getOffset() != null && pageable.getRowOfPage() != null) {
            sqlQuery.append("LIMIT " + pageable.getOffset() + ", " + pageable.getRowOfPage() + " ");
        }
        try {
            return query(sqlQuery.toString(), new PostsMapper());
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Long save(Posts posts) {
        String sql = "INSERT INTO posts(title, thumbnail, short_decription, content, categoryid, create_date, create_by) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            return insert(sql, posts.getTitle(), posts.getThumbnail(), posts.getShortDecription(), posts.getContent(), posts.getCategoryId(), posts.getCreateDate(), posts.getCreateBy());
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Posts fillById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        try {
            return fillById(sql, new PostsMapper(), id, new Posts());
        } catch (SQLException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Integer count() {
        String sql = "SELECT count(*) FROM posts";
        try {
            return count(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }
}
