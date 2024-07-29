package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator;

public class FabricValidate {
    public static IValidateAdapter getValidate() { return new ValidateAdapter(new EmailAndNameAndPasswordValidate(), new NameValidate()); }
}
