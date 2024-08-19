package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.*;

import java.util.ArrayList;
import java.util.regex.Pattern;


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
        var REGEX_DECORATOR = Pattern.compile("BACKEND|FRONTEND|DATABASE", Pattern.CASE_INSENSITIVE);
        String name = ExtensionsIO.getInput("Digite o nome do projeto: ");
        String description = ExtensionsIO.getInput("Digite a descrição do projeto: ");
        Status status = Status.INITIAL;
        ArrayList<ProjectTypes> projectTypes = new ArrayList<>();
        String s = ExtensionsIO.getInput("Digite o tipo/tipos de projeto com virgula\nex: Backend, FrontEnd");
        for (String x : s.split(",")) {
            Boolean isRx = REGEX_DECORATOR.matcher(x.trim()).matches();
            if(isRx) {
                projectTypes.add(ProjectTypes.valueOf(x.trim().toUpperCase()));
            }
        }

        return new Project.Build().name(name).description(description).Status(status).projectTypes(projectTypes);
    }
}
