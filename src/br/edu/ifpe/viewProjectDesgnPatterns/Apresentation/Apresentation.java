package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;


import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;
import java.util.List;
import java.util.Scanner;

public class Apresentation {
    private static Apresentation instaceApresentationUnique;
    private UserService userService = UserService.getInstanceUserService();

    public static Apresentation getinstaceApresentationUnique() {
        if (instaceApresentationUnique == null) {
            instaceApresentationUnique = new Apresentation();
        }
        return instaceApresentationUnique;
    }

    public void DesktopScreen () {
        Scanner Input = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Enter Opção \n0 - encerrar\n1 - adicionar\n2- listar usuaios");
            opcao = Integer.parseInt(Input.nextLine());
            switch (opcao) {
                case 0:
                    this.optionChose("Encerrar");
                    break;
                case 1:
                    this.optionChose("Adicionar");
                    this.addUser(Input);
                    break;
                case 2:
                    this.optionChose("Listar");
                    this.ListarUser(Input);
                    break;

                default:
                    System.out.println("opção invalida");
                    break;
            }
        }
    }

    private void addUser(Scanner Input) {
        System.out.println("Digite o nome do usuario: ");
        String name = Input.nextLine();
        System.out.println("Digite o Email: ");
        String email = Input.nextLine();
        System.out.println("Digite o Password: ");
        String password = Input.nextLine();
        boolean result = false;
        try {
            result = userService.add(new User.Build().Name(name).Email(email).Password(password).Role(Role.CLIENT).build());
        } catch (Exception e) {
            System.out.println("erro ao adicionar");
            AddLn();
        }
        if (result) {
            System.out.println("adicionado com sucesso");
            AddLn();
        }
    }

    private void AddLn() {
        System.out.println("\n");
        System.out.println("\n");
    }

    private void ListarUser(Scanner Input) {
        List<User> allUser = userService.getAllUser();
        if (allUser.size() == 0) {
            System.out.println("não há usuarios");
        }
        for (User user : allUser) {
            System.out.println("usuario: "+ user.getName() + " Id: " + user.getId());
        }
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
