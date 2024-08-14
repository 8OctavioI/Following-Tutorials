package com.octavioi.Exceptions;

public class AmountInvalidException extends Exception {
    public AmountInvalidException() {
        super("Amount Invalid!");
    }
    public AmountInvalidException(Throwable cause) {
        super(cause);
    }
    
}
