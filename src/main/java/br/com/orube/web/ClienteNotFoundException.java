package br.com.orube.web;

public class ClienteNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3242512016842878121L;

    public ClienteNotFoundException() {

    }

    public ClienteNotFoundException(Long clienteId) {
	super("cliente: " + clienteId + " not found.");
    }
}
