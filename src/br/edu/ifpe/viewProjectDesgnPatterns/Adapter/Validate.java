package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateEmailPassword;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateName;

public class Validate {
    private final EmailAndNameAndPasswordValidate validatePassword;
    private final NameValidate validateName;

    public Validate(EmailAndNameAndPasswordValidate validatePassword, NameValidate validateName) {
        this.validatePassword = validatePassword;
        this.validateName = validateName;
    }

    public boolean IsValid(String name) {
        var validateResult = validateName.validate(new ValidateName(name));
        return validateResult.isValid();
    }

    public boolean IsValid(String name, String email, String password) {
        var validateResult = validatePassword.validate(new ValidateEmailPassword(name, email, password));
        return validateResult.isValid();
    }
}
