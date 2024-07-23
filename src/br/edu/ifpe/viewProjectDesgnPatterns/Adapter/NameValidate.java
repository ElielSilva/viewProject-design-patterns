package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;
import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.ValidateName;

import static br.com.fluentvalidator.predicate.StringPredicate.*;

public class NameValidate extends AbstractValidator<ValidateName> {

    @Override
    public void rules() {
        ruleFor(ValidateName::getName)
                .must((stringSizeBetween(3, 20)))
                .withMessage("Digite um nome Valido")
                .withFieldName("Nome");

    }



}
