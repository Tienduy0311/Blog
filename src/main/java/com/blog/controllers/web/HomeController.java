package com.blog.controllers.web;

import com.blog.constant.Constant;
import com.blog.constant.SessionConstant;
import com.blog.dao.IUserDAO;
import com.blog.model.Category;
import com.blog.model.User;
import com.blog.service.ICategoryService;
import com.blog.service.IUserService;
import com.blog.utils.BeanUtil;
import com.blog.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/trang-chu", "/login", "/logout"})
public class HomeController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IUserService userService;

    private ResourceBundle bundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = (String) req.getParameter("action");
        if ("login".equals(action)) {
            String error = (String) req.getParameter("error");
            if (error != null) {
                req.setAttribute("error", bundle.getString(error));
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
            dispatcher.forward(req, resp);
        } else if ("logout".equals(action)) {
            SessionUtil.getInstance().removeValue(req, SessionConstant.SESSION_USER);
            resp.sendRedirect("/trang-chu");
        } else {
            Category category = new Category();
            category.setId(15);
            category.setName("Viet Nam");
            category.setCode("Viet-Nam-update");
            Category category1 = categoryService.fillById(15L);
            //categoryService.update(category);
            //req.setAttribute("category", categoryService.fillAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/home.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = (String) req.getParameter("action");
        if ("login".equals(action)) {
            User userRequest = BeanUtil.toModel(new User(), req);
            User userResponse = userService.getAllByUserNamePassword(userRequest.getUserName(), userRequest.getPassword());
            if (userResponse.getUserName() != null) {
                SessionUtil.getInstance().putValue(req, SessionConstant.SESSION_USER, userResponse);
                if (Constant.ROLE_ADMIN.equals(userResponse.getRole().getCode())) {
                    resp.sendRedirect("/admin-dashboard");
                } else if (Constant.ROLE_USER.equals(userResponse.getRole().getCode())){
                    resp.sendRedirect("/trang-chu");
                }
            } else {
                resp.sendRedirect("/login?action=login&error=login_fail");
            }
        }
    }
}
