package com.beadando.exceptions;

public class BadDiscNumber extends Throwable {
    public BadDiscNumber(int discNumber){
        super(String.valueOf(discNumber));
    }
}
