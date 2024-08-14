package com.octavioi;

import com.octavioi.Exceptions.AmountInvalidException;

public interface Transactable {
    Double withdraw() throws AmountInvalidException;
    Double deposit() throws AmountInvalidException;
    Double getBalance();
} 
