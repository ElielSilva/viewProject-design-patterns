package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Apresentation {
    private static Apresentation instaceApresentationUnique;
    private UserService userService = UserService.getInstanceUserService();
   // private ProjectService projectService = ProjectService.getInstanceProjectService();
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

    private User createNewUser(Integer id ) {
        Optional<Integer> ln = Optional.ofNullable(id);
        System.out.println("Digite o nome do usuario: ");
        String name = this.scanner.nextLine();
        System.out.println("Digite o Email: ");
        String email = this.scanner.nextLine();
        System.out.println("Digite o Password: ");
        String password = this.scanner.nextLine();
        if (ln.isPresent()) {
            return new User.Build().id(id).name(name).email(email).password(password).role(Role.CLIENT).build();
        }
        return new User.Build().name(name).email(email).password(password).role(Role.CLIENT).build();
    }

    private void addUser() {
        this.optionChose("Adicionar user");
        try {
            userService.add(createNewUser(null));
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
        List<User> allUser = userService.get();
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
            userService.delete(id);
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
            userService.update(createNewUser(id));
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
            user = userService.get(id);
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
