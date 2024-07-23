package br.edu.ifpe.viewProjectDesgnPatterns.Adapter;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;

public class AdapterValidate {
    private final UserValidate validateU = new UserValidate();
    private final ProjectValidate validateP = new ProjectValidate();


    public boolean isValidate (String n1, String n2 , String n3) {
        return validateU.validate(new User.Build().Name(n1).Email(n2).Password(n3).build()).isValid();
    }

    public boolean isValidate (String n1) {
        return validateP.validate(new Project.Build().Name(n1).build()).isValid();
    }
}
