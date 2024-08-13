package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.Facade;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuUser {
    public Facade facade = new Facade();
    private static final String MENU = "Enter Opção \n" + "0 - encerrar\n1 - adicionar\n2- listar usuaios\n3 - Listar usuario por id\n4 - deletar\n5 - modificar";
    private Scanner scanner;

    public void showMenuUser () {
        this.scanner = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println(MENU);
            opcao = Integer.parseInt(this.scanner.nextLine());
            switch (opcao) {
                case 0:
                    this.optionChose("Encerrar");
                    break;
                case 1:
                    this.addUser();
                    break;
                case 2:
                    this.listUser();
                    break;
                case 3:
                    this.listUserById();
                    break;
                case 4:
                    this.deleteUser();
                    break;
                case 5:
                    this.updateUser();
                    break;
                default:
                    System.out.println("opção invalida");
                    break;
            }
        }
    }

    private String getInput(String prompt) {
        System.out.println(prompt);
        return this.scanner.nextLine();
    }

    private User.Build createNewUser() {
        String name = getInput("Digite o nome do usuario: ");
        String email = getInput("Digite o Email: ");
        String password = getInput("Digite o Password: ");
        return new User.Build().name(name).email(email).password(password).role(Role.CLIENT);
    }

    private void addUser() {
        this.optionChose("Adicionar user");
        try {
            facade.addUser(createNewUser().build());
        } catch (Exception e) {
            System.out.println("erro ao adicionar");
        }
        System.out.println("adicionado com sucesso");
        addLn();

    }

    private void addLn() {
        System.out.println("\n");
        System.out.println("\n");
    }

    private void listUser() {
        this.optionChose("Listar todos os usuarios");
        List<User> allUser = facade.getUser();
        if (allUser.isEmpty()) {
            System.out.println("não há usuarios");
        }
        for (User user : allUser) {
            System.out.println("usuario: "+ user.getName() + " Id: " + user.getId());
        }
        addLn();
    }

    private void deleteUser() {
        this.optionChose("Deletar usuario");
        System.out.println("Digite o id do usuario: ");
        int id = Integer.parseInt(this.scanner.nextLine());
        try {
            facade.deleteUser(id);
        } catch (NotFoundEntity e) {
            System.out.println("erro ao deletar usuario");
        }
        System.out.println("deletado com sucesso");
        addLn();
    }

    private void updateUser() {
        this.optionChose("Atualizar usuario");
        System.out.println("Digite o id do usuario: ");
        int id = Integer.parseInt(this.scanner.nextLine());
        try {
            facade.updateUser(createNewUser().id(id).build());
        } catch (Exception e) {
            System.out.println("erro ao atualizar");
        }
        addLn();
    }

    private void listUserById() {
        this.optionChose("Listar usuario por Id");
        System.out.println("Digite o id do usuario: ");
        int id = Integer.parseInt(this.scanner.nextLine());
        User user = null;
        try {
            user = facade.getUser(id);
        } catch (NotFoundEntity e) {
            System.out.println(e.getMessage());
        }
        if (user != null)
            System.out.printf("usuario: %s Id: %d%n", user.getName(), user.getId());
        addLn();
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
