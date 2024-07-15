package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;
import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Predicate;

import static br.com.fluentvalidator.predicate.LocalDatePredicate.*;
import static br.com.fluentvalidator.predicate.StringPredicate.*;

public class ProjectValidate extends AbstractValidator<Project> {

    @Override
    public void rules() {
        ruleFor(Project::getName)
                .must((stringSizeBetween(3, 20)))
                .withMessage("Digite um nome Valido")
                .withFieldName("nome eliel");

//        ruleFor(Project::getStartDate)
//                .must(localDateBeforeOrEqual(LocalDate.now()))
//                .withMessage("Informe uma data valida")
//                .withFieldName("Start date");


    }



}
