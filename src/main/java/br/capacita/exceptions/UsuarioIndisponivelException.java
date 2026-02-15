package br.capacita.exceptions;

public class UsuarioIndisponivelException extends RuntimeException {
    public UsuarioIndisponivelException(String message) {
        super(message);
    }
}
