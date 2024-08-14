package com.octavioi;

import com.octavioi.Exceptions.AmountInvalidException;

public interface Transactable {
    Double withdraw() throws AmountInvalidException;
    Double withdraw(Double amount) throws AmountInvalidException;
    Double deposit() throws AmountInvalidException;
    Double deposit(Double amount) throws AmountInvalidException;
    Double getBalance();
} 
