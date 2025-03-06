package com.academy.controller;

import com.academy.model.User;
import com.academy.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        AuthService authService = new AuthService();

        if (authService.authenticate(login, password)) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Hello " + login + " " + password);
            out.println("</body>");
            out.println("</html>");

            User user = new User(login, password);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Access denied");
            out.println("</body>");
            out.println("</html>");
        }

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "";

        BufferedReader reader = request.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            data += line;
        };

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(data);
        out.println("</body>");
        out.println("</html>");

        out.close();

    }
}
