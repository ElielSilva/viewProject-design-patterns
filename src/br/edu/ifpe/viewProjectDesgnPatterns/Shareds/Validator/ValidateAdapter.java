package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateEmailPassword;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateName;

public class ValidateAdapter implements IValidateAdapter {
    private final EmailAndNameAndPasswordValidate validatePassword;
    private final NameValidate validateName;

    public ValidateAdapter(EmailAndNameAndPasswordValidate validatePassword, NameValidate validateName) {
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
