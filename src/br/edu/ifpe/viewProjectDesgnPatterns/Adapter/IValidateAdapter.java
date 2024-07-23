package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;

public interface IValidateAdapter {
    boolean IsValid(String name);
    boolean IsValid(String name, String email, String password);
}
