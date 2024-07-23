package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;

import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateEmailPassword;

import static br.com.fluentvalidator.predicate.StringPredicate.stringMatches;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeBetween;

public class EmailAndNameAndPasswordValidate extends AbstractValidator<ValidateEmailPassword> {

    @Override
    public void rules() {
        ruleFor(ValidateEmailPassword::getName)
            .must((stringSizeBetween(3, 20)))
            .withMessage("Digite um nome Valido")
            .withFieldName("Name");

        ruleFor(ValidateEmailPassword::getEmail)
            .must((stringMatches("\\S+@\\S+.\\S+")))
            .withMessage("Email is not valid")
            .withFieldName("Email");

        ruleFor(ValidateEmailPassword::getPassword)
                .must((stringMatches("^(?=.*[A-Z])(?=.*[!#@$%&])(?=.*[0-9])(?=.*[a-z]).{6,15}$")))
                .withMessage("Password is not valid")
                .withFieldName("Password");
        
    }
}
