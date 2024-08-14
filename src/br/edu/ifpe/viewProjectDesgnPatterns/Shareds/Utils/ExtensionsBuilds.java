package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;


public class ExtensionsBuilds {

    public static User.Build createNewUser() {
        String name = ExtensionsIO.getInput("Digite o seu Nome: ");
        String email = ExtensionsIO.getInput("Digite o Email: ");
        String password = ExtensionsIO.getInput("Digite o Password: ");
        return new User.Build().name(name).email(email).password(password).role(Role.CLIENT);
    }

    public static User.Build createNewUseLogin() {
        String email = ExtensionsIO.getInput("Digite o Email: ");
        String password = ExtensionsIO.getInput("Digite o Password: ");
        return new User.Build().name("try login").email(email).password(password).role(Role.CLIENT);
    }

    public static Project.Build createNewProject() {
        String name = ExtensionsIO.getInput("Digite o nome do projeto: ");
        return new Project.Build().name(name);
    }
}
