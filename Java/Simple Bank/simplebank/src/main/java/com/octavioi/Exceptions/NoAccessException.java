package com.octavioi.Exceptions;

public class NoAccessException extends Exception{
    public NoAccessException() {
        super("You were denied access. ");
    }

    public NoAccessException(Throwable cause) {
        super(cause);
    }
    
}
