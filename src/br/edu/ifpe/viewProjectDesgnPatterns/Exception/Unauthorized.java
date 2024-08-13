package br.edu.ifpe.viewProjectDesgnPatterns.Exception;

public class Unauthorized extends Exception {
    public Unauthorized() {
    }

    public Unauthorized(String message) {
        super(message);
    }

    public Unauthorized(String message, Throwable cause) {
        super(message, cause);
    }

    public Unauthorized(Throwable cause) {
        super(cause);
    }

    public Unauthorized(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
