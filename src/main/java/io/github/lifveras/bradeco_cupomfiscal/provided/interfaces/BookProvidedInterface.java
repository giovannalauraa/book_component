package io.github.lifveras.bradeco_cupomfiscal.provided.interfaces;

import java.util.List;

import io.github.lifveras.bradeco_cupomfiscal.internal.model.Book;

public interface BookProvidedInterface {
    Book createBook(String title, String author);
    Book getBookById(int id);
    List<Book> getAllBooks();
    boolean deleteBook(int id);
}