package com.academy.controller;

import com.academy.model.Book;
import com.academy.model.User;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        BookService bookService = new BookService();
        Book book = bookService.getBookById(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(book);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
