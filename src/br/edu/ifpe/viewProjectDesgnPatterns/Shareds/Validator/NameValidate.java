package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator;

import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateName;

import static br.com.fluentvalidator.predicate.StringPredicate.stringMatches;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeBetween;

public class NameValidate extends AbstractValidator<ValidateName> {

    private static final int MIN_LENGTH_NAME = 3;
    private static final int MAX_LENGTH_NAME = 20;

    @Override
    public void rules() {
        ruleFor(ValidateName::getName)
                .must((stringSizeBetween(MIN_LENGTH_NAME, MAX_LENGTH_NAME)))
                .withMessage("Digite um nome Valido")
                .withFieldName("Nome");

    }
}
