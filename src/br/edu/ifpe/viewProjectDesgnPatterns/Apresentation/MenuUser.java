package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.Facade;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsBuilds;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsIO;

import java.util.List;

public class MenuUser {
    public Facade facade = new Facade();
    private static final String MENU = "Enter Opção \n" + "0 - voltar\n1 - adicionar\n2 - listar usuarios\n3 - Listar usuario por id\n4 - deletar\n5 - modificar";

    public void showMenuUser () {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println(MENU.toUpperCase());
            opcao = Integer.parseInt(ExtensionsIO.getInput("DIGITE A OPÇÃO DESEJADA: "));
            switch (opcao) {
                case 0:
                    ExtensionsIO.optionChose("VOLTAR");
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
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }
        }
    }

    private void addUser() {
        ExtensionsIO.optionChose("Adicionar user");
        ExtensionsIO.addLn();
        try {
            facade.addUser(ExtensionsBuilds.createNewUser().build());
        } catch (Exception e) {
            System.out.println("erro ao adicionar");
        }
        System.out.println("adicionado com sucesso");
        ExtensionsIO.addLn();
    }


    private void listUser() {
        ExtensionsIO.optionChose("Listar todos os usuarios");
        ExtensionsIO.addLn();
        List<User> allUser = null;
        ExtensionsIO.addLn();
        try {
            allUser = facade.getUser();
            if (allUser.isEmpty()) {
                System.out.println("não há usuarios");
            }
            for (User user : allUser) {
                System.out.println("usuario: "+ user.getName() + " Id: " + user.getId());
            }
        } catch (NotFoundEntity e) {
            System.out.println("Ainda não existe dados inseridos na base");
        }
        ExtensionsIO.addLn();
    }

    private void deleteUser() {
        ExtensionsIO.optionChose("Deletar usuario");
        ExtensionsIO.addLn();
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do usuario: "));
        try {
            facade.deleteUser(id);
        } catch (NotFoundEntity e) {
            System.out.println("erro ao deletar usuario");
        }
        System.out.println("deletado com sucesso");
        ExtensionsIO.addLn();
    }

    private void updateUser() {
        ExtensionsIO.optionChose("Atualizar usuario");
        ExtensionsIO.addLn();
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do usuario: "));
        try {
            facade.updateUser(ExtensionsBuilds.createNewUser().id(id).build());
        } catch (Exception e) {
            System.out.println("ERRO AO ATUALIZAR USUARIO");
        }
        ExtensionsIO.addLn();
    }

    private void listUserById() {
        ExtensionsIO.optionChose("Listar usuario por Id");
        ExtensionsIO.addLn();
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do usuario: "));
        User user = null;
        try {
            user = facade.getUser(id);
        } catch (NotFoundEntity e) {
            System.out.println(e.getMessage());
        }
        if (user != null)
            System.out.printf("usuario: %s Id: %d%n", user.getName(), user.getId());
        ExtensionsIO.addLn();
    }
}
