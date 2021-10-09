package com.blog.mapper;

import com.blog.model.Posts;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostsMapper implements RowMapper<Posts>{
    @Override
    public Posts mapRow(ResultSet rs) throws SQLException {
        Posts posts = new Posts();
        posts.setId(rs.getLong("id"));
        posts.setTitle(rs.getString("title"));
        posts.setThumbnail(rs.getString("thumbnail"));
        posts.setShortDecription(rs.getString("short_decription"));
        posts.setContent(rs.getString("content"));
        posts.setCategoryId(rs.getLong("categoryid"));
        posts.setCreateDate(rs.getTimestamp("create_date"));
        posts.setModifiedDate(rs.getTimestamp("modified_date"));
        posts.setCreateBy(rs.getString("create_by"));
        posts.setModifiedBy(rs.getString("modified_by"));
        return posts;
    }
}
