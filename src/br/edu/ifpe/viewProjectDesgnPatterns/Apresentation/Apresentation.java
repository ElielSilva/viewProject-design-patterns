package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;


import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;

import java.io.IOException;
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
                    this.finishTerminal();
                case 1:
                    this.addUser(Input);
                case 2:
                    this.ListarUser(Input);


                case 5:
                    limparTerminal();
            }
        }



    }

    private void addUser(Scanner Input) {
        System.out.println("Digite o nome do usuario");
        String name = Input.nextLine();
        System.out.println("Digite o Email");
        String email = Input.nextLine();
        System.out.println("Digite o Password");
        String password = Input.nextLine();
        boolean result = userService.add(new User.Build().Name(name).Email(email).Password(password).Role(Role.CLIENT).build());
        if (result) {
            System.out.println("adicionado com sucesso");
        }
        System.out.println("errooooo");
    }

    private void ListarUser(Scanner Input) {
        List<User> allUser = userService.getAllUser();
        if (allUser.size() == 0) {
            System.out.println("não há usuarios");
        }
        for (User user : allUser) {
            System.out.println("usuario: "+ user.getName());
        }
    }

    private void finishTerminal() {
        System.out.println("programa encerrado");
    }

    private void limparTerminal(){
        System.out.flush();
    }
}
