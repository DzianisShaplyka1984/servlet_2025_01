package com.academy.service;

import com.academy.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();

        Book book = new Book(1, "Title1", 1000);
        Book book1 = new Book(2, "Title2", 2001);
        Book book2 = new Book(3, "Title3", 3002);
        Book book3 = new Book(4, "Title4", 3003);

        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(Integer id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }
}
