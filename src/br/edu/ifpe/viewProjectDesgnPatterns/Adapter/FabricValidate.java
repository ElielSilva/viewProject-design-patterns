package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;

public class FabricValidate {
    public static Validate getValidate() {
        return new Validate(new EmailAndNameAndPasswordValidate(), new NameValidate());
    }
}
