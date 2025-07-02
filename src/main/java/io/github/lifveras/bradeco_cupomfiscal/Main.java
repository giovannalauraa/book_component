package io.github.lifveras.bradeco_cupomfiscal;

import io.github.lifveras.bradeco_cupomfiscal.internal.model.Book;
import io.github.lifveras.bradeco_cupomfiscal.provided.BookComponenteInterface;
import io.github.lifveras.bradeco_cupomfiscal.provided.interfaces.BookProvidedInterface;

public class Main {
    public static void main(String[] args) {
        BookComponenteInterface componente = new BookComponenteInterface();
        componente.initialize();

        BookProvidedInterface bookPort = null;
        for (BookProvidedInterface port : componente.getPorts()) {
            if ("bookOpsPort".equals(port.getId())) {
                bookPort = port;
                break;
            }
        }

        if (bookPort == null) {
            System.out.println("Porto 'bookOpsPort' não encontrado.");
            return;
        }

        Book b1 = bookPort.createBook("1984", "George Orwell");
        Book b2 = bookPort.createBook("Clean Code", "Robert C. Martin");

        System.out.println("\nLivro 1 criado: " + b1.getTitle());
        System.out.println("Livro 2 criado: " + b2.getTitle());
        System.out.println("\nTodos os livros:");
        for (Book b : bookPort.getAllBooks()) {
            System.out.println(b.getId() + ": " + b.getTitle() + " - " + b.getAuthor());
        }
    }
}
