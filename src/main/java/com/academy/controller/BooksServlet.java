package com.academy.controller;

import com.academy.model.Book;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        BookService bookService = new BookService();

        List<Book> books = bookService.getBooks();

        request.setAttribute("books", books);

        HttpSession session = request.getSession();

        session.setAttribute("books", "Hello World");

        request.getRequestDispatcher("/WEB-INF/page/books.jsp").forward(request, response);
    }
}
