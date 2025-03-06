package com.academy.filter;

import com.academy.model.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String url = request.getRequestURL().toString();
        String method = request.getMethod();

        if ((user != null) || (url.contains("/login") && "GET".equalsIgnoreCase(method)))  {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

        }
    }
}
