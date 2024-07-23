package br.edu.ifpe.viewProjectDesgnPatterns.Exception;

public class NotFoundEntity extends Exception {
    public NotFoundEntity() {
    }

    public NotFoundEntity(String message) {
        super(message);
    }

    public NotFoundEntity(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundEntity(Throwable cause) {
        super(cause);
    }

    public NotFoundEntity(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
