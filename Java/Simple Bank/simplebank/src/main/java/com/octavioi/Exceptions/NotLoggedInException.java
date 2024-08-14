package com.octavioi.Exceptions;

public class NotLoggedInException extends Exception {

    public NotLoggedInException() {
        super("Please log in to access account. ");
    }
    
}
