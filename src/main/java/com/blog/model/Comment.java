package com.blog.model;

import java.sql.Timestamp;

public class Comment extends BaseModel<Comment> {
    private String content;
    private long userId;
    private long postsId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostsId() {
        return postsId;
    }

    public void setPostsId(long postsId) {
        this.postsId = postsId;
    }
}
