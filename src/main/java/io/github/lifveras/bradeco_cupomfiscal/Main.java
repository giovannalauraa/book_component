package io.github.lifveras.bradeco_cupomfiscal;

import io.github.lifveras.bradeco_cupomfiscal.internal.model.Book;
import io.github.lifveras.bradeco_cupomfiscal.provided.BookComponenteInterface;
import io.github.lifveras.bradeco_cupomfiscal.provided.interfaces.BookProvidedInterface;

public class Main {
    public static void main(String[] args) {
        // Instancia o componente e inicializa
        BookComponenteInterface componente = new BookComponenteInterface();
        componente.initialize();

        // Conecta uma porta required simulada (ex: logger, repositório externo)
        componente.connect("logger", new Object()); 

        // Acessa a porta provided usando getProvidedInterface (padrão Beyond)
        BookProvidedInterface bookPort = (BookProvidedInterface) componente.getProvidedInterface("bookOpsPort");

        if (bookPort == null) {
            System.out.println("Porta 'bookOpsPort' não encontrada.");
            return;
        }

        // Usa o serviço através da porta provided (interface pública)
        Book b1 = bookPort.createBook("1984", "George Orwell");
        Book b2 = bookPort.createBook("Clean Code", "Robert C. Martin");

        System.out.println("\nLivro 1 criado: " + b1.getTitle());
        System.out.println("Livro 2 criado: " + b2.getTitle());

        System.out.println("\nTodos os livros:");
        for (Book b : bookPort.getAllBooks()) {
            System.out.println(b.getId() + ": " + b.getTitle() + " - " + b.getAuthor());
        }

        // Desconecta a porta required
        componente.disconnect("logger");
    }
}
