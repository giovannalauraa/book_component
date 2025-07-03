package io.github.lifveras.bradeco_cupomfiscal.provided;

import io.github.lifveras.bradeco_cupomfiscal.internal.BookService;
import io.github.lifveras.bradeco_cupomfiscal.provided.interfaces.BookProvidedInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookComponenteInterface {

    private String id;
    private BookService bookService;
    private List<BookProvidedInterface> ports;

    private final Map<String, Object> requiredPorts = new HashMap<>();

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

    public Object getProvidedInterface(String portName) {
        for (BookProvidedInterface port : ports) {
            if (port.getId().equals(portName)) {
                return port;
            }
        }
        return null;
    }

    public void connect(String portName, Object component) {
        // Conecta porta required
        requiredPorts.put(portName, component);
        System.out.println("Conectado à porta required: " + portName);
    }

    public void disconnect(String portName) {
        if (requiredPorts.containsKey(portName)) {
            requiredPorts.remove(portName);
            System.out.println("Desconectado da porta required: " + portName);
        }
    }

    public Object getRequiredInterface(String portName) {
        return requiredPorts.get(portName);
    }
}
