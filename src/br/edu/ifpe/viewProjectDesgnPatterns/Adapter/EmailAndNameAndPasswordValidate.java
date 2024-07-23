package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;
import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateEmailPassword;

import static br.com.fluentvalidator.predicate.StringPredicate.*;

public class EmailAndNameAndPasswordValidate extends AbstractValidator<ValidateEmailPassword> {

    private static final int MIN_LENGTH_NAME = 3;
    private static final int MAX_LENGTH_NAME = 20;
    private static final String REGEX_EMAIL = "\\S+@\\S+.\\S+";
    private static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[!#@$%&])(?=.*[0-9])(?=.*[a-z]).{6,15}$";

    @Override
    public void rules() {
        ruleFor(ValidateEmailPassword::getName)
                .must((stringSizeBetween(MIN_LENGTH_NAME, MAX_LENGTH_NAME)))
                .withMessage("Digite um nome Valido")
                .withFieldName("Name");

        ruleFor(ValidateEmailPassword::getEmail)
                .must((stringMatches(REGEX_EMAIL)))
                .withMessage("Email is not valid")
                .withFieldName("Email");

        ruleFor(ValidateEmailPassword::getPassword)
                .must((stringMatches(REGEX_PASSWORD)))
                .withMessage("Password is not valid")
                .withFieldName("Password");

    }
}
