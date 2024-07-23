package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;

public class FabricValidate {
    public static IValidateAdapter getValidate() { return new ValidateAdapter(new EmailAndNameAndPasswordValidate(), new NameValidate()); }
}
