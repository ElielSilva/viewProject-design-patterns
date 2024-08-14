package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsIO;

public class Presentation {
    private static Presentation instaceApresentationUnique;
    private User actualUser;
    private static final String MENU_MAIN = "Enter Opção \n" + "0 - encerrar\n1 - editar usuarios\n2 - editar projetos";

    public static Presentation getinstaceApresentationUnique() {
        if (instaceApresentationUnique == null) {
            instaceApresentationUnique = new Presentation();
        }
        return instaceApresentationUnique;
    }

    public void DesktopScreen () {
        this.redirectMenuLogin();

        int opcao = -1;
        while (opcao != 0) {
            ExtensionsIO.addLn();
            opcao = Integer.parseInt(ExtensionsIO.getInput(MENU_MAIN.toUpperCase()));
            switch (opcao) {
                case 0:
                    ExtensionsIO.optionChose("Encerrar".toUpperCase());
                    break;
                case 1:
                    this.redirectMenuUser();
                    break;
                case 2:
                    this.redirectMenuProject();
                    break;
                default:
                    System.out.println("opção invalida".toUpperCase());
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
}
