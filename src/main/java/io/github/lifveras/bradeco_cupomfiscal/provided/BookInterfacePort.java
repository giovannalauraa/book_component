package io.github.lifveras.bradeco_cupomfiscal.provided;

import java.util.List;

import io.github.lifveras.bradeco_cupomfiscal.internal.BookService;
import io.github.lifveras.bradeco_cupomfiscal.internal.model.Book;
import io.github.lifveras.bradeco_cupomfiscal.provided.interfaces.BookProvidedInterface;

public class BookInterfacePort implements BookProvidedInterface {

    private final String id;
    private final BookService bookService;

    public BookInterfacePort(BookService bookService) {
        this.id = "bookOpsPort";
        this.bookService = bookService;
        initialize();
    }

    public String getId() {
        return id;
    }

    @Override
    public void initialize() {
        System.out.println("BookInterfacePort inicializado.");
    }

    @Override
    public Book createBook(String title, String author) {
        return bookService.create(title, author);
    }

    @Override
    public Book getBookById(int id) {
        return bookService.getById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @Override
    public boolean deleteBook(int id) {
        return bookService.delete(id);
    }
}
