package com.blog.controllers.api.admin;

import com.blog.model.Posts;
import com.blog.service.IPostsService;
import com.blog.utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api-posts")
public class PostsAPI extends HttpServlet {

    @Inject
    IPostsService postsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String json = HttpUtils.of(req.getReader());
        Posts posts = HttpUtils.toModel(json, Posts.class);
        Long id = postsService.save(posts);
        ObjectMapper objectMapper = new ObjectMapper();
        if (id != null) {
            objectMapper.writeValue(resp.getOutputStream(), postsService.fillById(id));
        } else {
            objectMapper.writeValue(resp.getOutputStream(), "error!");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
