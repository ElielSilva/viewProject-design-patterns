package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;

import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;

import java.util.function.Predicate;

import static br.com.fluentvalidator.predicate.StringPredicate.stringMatches;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeBetween;

public class UserValidate extends AbstractValidator<User> {

    @Override
    public void rules() {
        ruleFor(User::getName)
            .must((stringSizeBetween(3, 20)))
            .withMessage("Digite um nome Valido")
            .withFieldName("Name");

        ruleFor(User::getEmail)
            .must((stringMatches("\\S+@\\S+.\\S+")))
            .withMessage("Email is not valid")
            .withFieldName("Email");

        ruleFor(User::getPassword)
                .must((stringMatches("^(?=.*[A-Z])(?=.*[!#@$%&])(?=.*[0-9])(?=.*[a-z]).{6,15}$")))
                .withMessage("Password is not valid")
                .withFieldName("Password");
        
    }
}
