package io.github.lifveras.bradeco_cupomfiscal;

import io.github.lifveras.bradeco_cupomfiscal.internal.model.Book;
import io.github.lifveras.bradeco_cupomfiscal.provided.BookComponenteInterface;
import io.github.lifveras.bradeco_cupomfiscal.provided.interfaces.BookProvidedInterface;

public class Main {
    public static void main(String[] args) {
        BookComponenteInterface componente = new BookComponenteInterface();
        componente.initialize();

        // Recupera o porto pelo ID
        BookProvidedInterface bookPort = (BookProvidedInterface) componente.getPort("bookOpsPort");

        // Usa o porto para executar operações
        Book b1 = bookPort.createBook("1984", "George Orwell");
        Book b2 = bookPort.createBook("Clean Code", "Robert C. Martin");

        System.out.println("\nLivro 1 criado: " + b1.getTitle());
        System.out.println("\nLivro 2 criado: " + b2.getTitle());
        System.out.println("\nTodos os livros:");
        for (Book b : bookPort.getAllBooks()) {
            System.out.println(b.getId() + ": " + b.getTitle() + " - " + b.getAuthor());
        }
    }
}