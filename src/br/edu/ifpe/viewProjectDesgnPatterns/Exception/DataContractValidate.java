package br.edu.ifpe.viewProjectDesgnPatterns.Exception;

public class DataContractValidate extends Exception {
    public DataContractValidate() {
    }

    public DataContractValidate(String message) {
        super(message);
    }

    public DataContractValidate(String message, Throwable cause) {
        super(message, cause);
    }

    public DataContractValidate(Throwable cause) {
        super(cause);
    }

    public DataContractValidate(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
