package com.blog.controllers.admin;

import com.blog.PageAndSort.PageRequest;
import com.blog.PageAndSort.Pageable;
import com.blog.PageAndSort.Sorter;
import com.blog.model.Posts;
import com.blog.service.IPostsService;
import com.blog.utils.BeanUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-add-posts", "/admin-posts"})
public class PostsController extends HttpServlet {

    @Inject
    IPostsService postsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = (String) req.getParameter("type");
        if ("views".equals(type)) {
            Posts posts = BeanUtil.toModel(new Posts(), req);
            Pageable pageable = new PageRequest(posts.getStartPage(), posts.getRowOfPage(), new Sorter(posts.getSortName(), posts.getSortBy()));
            posts.setListModel(postsService.fillAll(pageable));
            Integer totalPage = (int) Math.ceil(postsService.getTotalItem() / (double) pageable.getRowOfPage());
            posts.setTotalPage(totalPage);
            posts.setStartPage(pageable.getStartPage());
            req.setAttribute("modelPosts", posts);
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/post-list.jsp");
            rd.forward(req, resp);
        } else if ("add".equals(type)) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/edit.jsp");
            rd.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
