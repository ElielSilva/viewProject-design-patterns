package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;


import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Apresentation {
    private static Apresentation instaceApresentationUnique;
    private UserService userService = UserService.getInstanceUserService();
    private Scanner scanner;

    public static Apresentation getinstaceApresentationUnique() {
        if (instaceApresentationUnique == null) {
            instaceApresentationUnique = new Apresentation();
        }
        return instaceApresentationUnique;
    }

    public void DesktopScreen () {
        this.scanner = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Enter Opção \n0 - encerrar\n1 - adicionar\n2- listar usuaios\n3 - Listar usuario por id");
            opcao = Integer.parseInt(this.scanner.nextLine());
            switch (opcao) {
                case 0:
                    this.optionChose("Encerrar");
                    break;
                case 1:
                    this.optionChose("Adicionar user");
                    this.addUser();
                    break;
                case 2:
                    this.optionChose("Listar todos os usuarios");
                    this.ListarUser();
                    break;
                case 3:
                    this.optionChose("Listar usuario por Id");
                    this.ListarUserById();
                    break;


                default:
                    System.out.println("opção invalida");
                    break;
            }
        }
    }

    private void addUser() {
        System.out.println("Digite o nome do usuario: ");
        String name = this.scanner.nextLine();
        System.out.println("Digite o Email: ");
        String email = this.scanner.nextLine();
        System.out.println("Digite o Password: ");
        String password = this.scanner.nextLine();
        try {
            userService.add(new User.Build().Name(name).Email(email).Password(password).Role(Role.CLIENT).build());
        } catch (Exception e) {
            System.out.println("erro ao adicionar");
            AddLn();
        }
        System.out.println("adicionado com sucesso");
        AddLn();

    }

    private void AddLn() {
        System.out.println("\n");
        System.out.println("\n");
    }

    private void ListarUser() {
        List<User> allUser = userService.getAllUser();
        if (allUser.size() == 0) {
            System.out.println("não há usuarios");
        }
        for (User user : allUser) {
            System.out.println("usuario: "+ user.getName() + " Id: " + user.getId());
        }
        AddLn();
    }

    private void ListarUserById() {
        System.out.println("Digite o id do usuario: ");
        int id = Integer.parseInt(this.scanner.nextLine());
        User user = userService.getUser(id);
        System.out.println("usuario: "+ user.getName() + " Id: " + user.getId());
        AddLn();
    }

    private void optionChose(String option) {
        StringBuilder chosenOption = new StringBuilder("################################### ");
        chosenOption.append(option);
        chosenOption.append(" ###################################");
        AddLn();
        System.out.println("#################################################################");
        System.out.println(chosenOption.toString());
        System.out.println("#################################################################");
        AddLn();
    }
}
