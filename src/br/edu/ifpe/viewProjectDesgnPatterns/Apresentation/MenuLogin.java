package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.Facade;

import java.util.List;
import java.util.Scanner;

public class MenuLogin {
    public Facade facade = new Facade();
    private static final String MENU = "Coloque as informações pra login \n";
    private Scanner scanner;

    public User showLoginMenu () {
        this.scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println(MENU);
                User user = createNewUser().build();
                return facade.searchUser(
                        u -> user.getEmail().equals(u.getEmail())
                //                && user.getPassword().equals(u.getPassword())
                );
            } catch (NotFoundEntity e) {
                optionChose("Email ou senha estão invalidos");
            }
        }
    };

    private String getInput(String prompt) {
        System.out.println(prompt);
        return this.scanner.nextLine();
    }

    private User.Build createNewUser() {
        String email = getInput("Digite o Email: ");
        String password = getInput("Digite o Password: ");
        return new User.Build().name("try login").email(email).password(password).role(Role.CLIENT);
    }

    private void addLn() {
        System.out.println("\n");
        System.out.println("\n");
    }

    private void optionChose(String option) {
        String chosenOption = "############################### " + option +
                " ###############################";
        addLn();
        System.out.println("#################################################################");
        System.out.println(chosenOption);
        System.out.println("#################################################################");
        addLn();
    }
}
