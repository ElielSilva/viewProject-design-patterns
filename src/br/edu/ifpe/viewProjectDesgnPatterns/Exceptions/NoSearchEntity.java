package br.edu.ifpe.viewProjectDesgnPatterns.Exceptions;

public class NoSearchEntity extends Exception {
    public NoSearchEntity() {
    }

    public NoSearchEntity(String message) {
        super(message);
    }

    public NoSearchEntity(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSearchEntity(Throwable cause) {
        super(cause);
    }

    public NoSearchEntity(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
