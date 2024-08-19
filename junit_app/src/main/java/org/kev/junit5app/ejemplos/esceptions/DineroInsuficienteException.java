package org.kev.junit5app.ejemplos.esceptions;

public class DineroInsuficienteException extends RuntimeException{
    public DineroInsuficienteException(String message) {
        super(message);
    }
}
