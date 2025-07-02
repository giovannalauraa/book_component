package io.github.lifveras.bradeco_cupomfiscal.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_cupomfiscal.internal.model.Book;

public class BookService {
    private final Map<Integer, Book> books = new HashMap<>();
    private int nextId = 1;

    public Book create(String title, String author) {
        Book book = new Book(nextId++, title, author);
        books.put(book.getId(), book);
        return book;
    }

    public Book getById(int id) {
        return books.get(id);
    }

    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    public boolean delete(int id) {
        return books.remove(id) != null;
    }
}