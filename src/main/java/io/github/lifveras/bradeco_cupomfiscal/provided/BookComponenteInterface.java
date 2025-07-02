package io.github.lifveras.bradeco_cupomfiscal.provided;

import io.github.lifveras.bradeco_cupomfiscal.internal.BookService;
import io.github.lifveras.bradeco_cupomfiscal.provided.interfaces.BookProvidedInterface;

import java.util.ArrayList;
import java.util.List;

public class BookComponenteInterface {

    private String id;
    private BookService bookService;
    private List<BookProvidedInterface> ports;

    public void initialize() {
        this.id = "bookComponent";
        this.bookService = new BookService();
        this.ports = new ArrayList<>();

        BookInterfacePort bookPort = new BookInterfacePort(bookService);
        ports.add(bookPort);
    }

    public String getId() {
        return id;
    }

    public List<BookProvidedInterface> getPorts() {
        return ports;
    }
}
