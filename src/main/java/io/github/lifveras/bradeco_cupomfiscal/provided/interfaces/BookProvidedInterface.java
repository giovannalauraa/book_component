package io.github.lifveras.bradeco_cupomfiscal.provided.interfaces;

import java.util.List;

import io.github.lifveras.bradeco_cupomfiscal.internal.model.Book;

public interface BookProvidedInterface {
    void initialize();
    Book createBook(String title, String author);
    Book getBookById(int id);
    String getId();
    List<Book> getAllBooks();
    boolean deleteBook(int id);
}