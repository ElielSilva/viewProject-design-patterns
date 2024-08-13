package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Presentation {
    private static Presentation instaceApresentationUnique;
    private User actualUser;
    //private UserService userService = UserService.getInstanceUserService();
    // private ProjectService projectService = ProjectService.getInstanceProjectService();
    private Scanner scanner;
    private static final String MENU_MAIN = "Enter Opção \n" + "0 - encerrar\n1 - editar usuarios\n2- editar projetos";

    public static Presentation getinstaceApresentationUnique() {
        if (instaceApresentationUnique == null) {
            instaceApresentationUnique = new Presentation();
        }
        return instaceApresentationUnique;
    }

    public void DesktopScreen () {
        this.scanner = new Scanner(System.in);
        this.redirectMenuLogin();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(MENU_MAIN);
            opcao = Integer.parseInt(this.scanner.nextLine());
            switch (opcao) {
                case 0:
                    this.optionChose("Encerrar");
                    break;
                case 1:
                    this.redirectMenuUser();
                    break;
                case 2:
                    this.redirectMenuProject();
                    break;
                default:
                    System.out.println("opção invalida");
                    break;
            }
        }
    }

    private void redirectMenuLogin(){
        MenuLogin menuLogin = new MenuLogin();
        this.actualUser = menuLogin.showLoginMenu();
    };

    private void redirectMenuUser(){
        MenuUser menu = new MenuUser();
        menu.showMenuUser();
    };

    private void redirectMenuProject(){
        MenuProject menu = new MenuProject();
        menu.showMenuProject(this.actualUser);
    };

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
