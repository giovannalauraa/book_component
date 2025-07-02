package io.github.lifveras.bradeco_cupomfiscal.provided;

import io.github.lifveras.bradeco_cupomfiscal.internal.BookService;
import io.github.lifveras.bredeco_pic_abstract.provided.ComponentInterface;

public class BookComponenteInterface extends ComponentInterface {

    private BookService bookService;

    @Override
    public void initialize() {
        this.id = "bookComponent";
        this.bookService = new BookService();

        BookInterfacePort bookPort = new BookInterfacePort(bookService);
        ports.add(bookPort);
    }
}
