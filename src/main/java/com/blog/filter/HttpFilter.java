package com.blog.filter;

import com.blog.constant.Constant;
import com.blog.constant.SessionConstant;
import com.blog.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpFilter implements Filter {
    private ServletContext context = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String url = httpServletRequest.getRequestURI();
        if (url.startsWith("/admin")) {
            User user = (User) httpServletRequest.getSession().getAttribute(SessionConstant.SESSION_USER);
            if (user != null) {
                if (Constant.ROLE_ADMIN.equals(user.getRole().getCode())) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (Constant.ROLE_USER.equals(user.getRole().getCode())) {
                    httpServletResponse.sendRedirect("/login?action=login&error=access_denied");
                }
            } else {
                httpServletResponse.sendRedirect("/login?action=login");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
