package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator;

public interface IValidateAdapter {
    boolean IsValid(String name);
    boolean IsValid(String name, String email, String password);
}
