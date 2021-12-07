package com.step03;

public class CustomException extends Exception {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
