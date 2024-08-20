package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.Facade;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsBuilds;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsIO;


public class MenuLogin {
    public Facade facade = new Facade();
    private static final String MENU = "Coloque as informações pra login \n";

    public User showLoginMenu () {
        while (true) {
            try {
                System.out.println(MENU.toUpperCase());
                User user = ExtensionsBuilds.createNewUseLogin().build();
                return facade.searchUser(
                        u -> user.getEmail().equals(u.getEmail())
                );
            } catch (NotFoundEntity e) {
                ExtensionsIO.optionChose("Email ou senha estão invalidos");
            }
        }
    };
}
