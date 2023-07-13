package com.example.domashka_osnovy_algoritmov1;

public class InvalidIndexExseption extends RuntimeException {
    public InvalidIndexExseption() {
    }

    public InvalidIndexExseption(String message) {
        super(message);
    }

    public InvalidIndexExseption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIndexExseption(Throwable cause) {
        super(cause);
    }

    public InvalidIndexExseption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
