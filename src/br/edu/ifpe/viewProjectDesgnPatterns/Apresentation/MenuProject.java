package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.Unauthorized;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.Facade;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsBuilds;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsIO;

import java.util.List;
import java.util.Scanner;

public class MenuProject {
    public Facade facade = new Facade();
    private User actualUser;
    private static final String MENU = "Enter Opção \n" + "0 - voltar\n1 - adicionar\n2 - listar Projetos\n3 - Listar Projetos por id\n4 - deletar Projetos\n5 - modificar Projetos";
    private Scanner scanner;

    public void showMenuProject (User actualUser) {
        this.actualUser = actualUser;
        int opcao = -1;
        while (opcao != 0) {
            System.out.println(MENU.toUpperCase());
            opcao = Integer.parseInt(ExtensionsIO.getInput("Digite a opção desejada"));
            switch (opcao) {
                case 0:
                    ExtensionsIO.optionChose("ENCERRAR");
                    break;
                case 1:
                    this.addProject();
                    break;
                case 2:
                    this.listProject();
                    break;
                case 3:
                    this.listProjectById();
                    break;
                case 4:
                    this.deleteProject();
                    break;
                case 5:
                    this.updateProject();
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }
        }
    }


    private void addProject() {
        ExtensionsIO.optionChose("Adicionar Projeto");
        try {
            facade.addProject(ExtensionsBuilds.createNewProject().build());
        } catch (Exception e) {
            System.out.println("erro ao adicionar");
        }
        System.out.println("adicionado com sucesso");
        ExtensionsIO.addLn();
    }


    private void listProject() {
        ExtensionsIO.optionChose("Listar todos os Projetos");
        List<Project> allProject = facade.getProject();
        if (allProject.isEmpty()) {
            System.out.println("não há Projetos");
        }
        for (Project project : allProject) {
            System.out.println("Projeto: "+ project.getName() + " Id: " + project.getId());
        }
        ExtensionsIO.addLn();
    }

    private void deleteProject() {
        ExtensionsIO.optionChose("Deletar Projeto");
        System.out.println("Digite o id do Projeto: ");
        int id = Integer.parseInt(this.scanner.nextLine());
        try {
            if(actualUser.getRole() == Role.ADMIN) {
                facade.deleteProject(id);

            }
            else {
                Project project = facade.getProject(id);
                if (project.getUserId() != actualUser.getId()) {
                    throw new Unauthorized();
                }
                facade.deleteProject(id);
            }
        } catch (NotFoundEntity | Unauthorized e) {
            System.out.println("erro ao deletar Projeto");
        }
        System.out.println("deletado com sucesso");
        ExtensionsIO.addLn();
    }

    private void updateProject() {
        ExtensionsIO.optionChose("Atualizar Projeto");
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do Project: "));
        try {
            Project project = facade.getProject(id);
            if(actualUser.getRole() == Role.ADMIN) {
                String newDescription = ExtensionsIO.getInput("Digite a nova descrição");
                project.setDescription(newDescription);
            }
            else {
                if (project.getUserId() != actualUser.getId()) {
                    throw new Unauthorized();
                }
                String newDescription = ExtensionsIO.getInput("Digite a nova descrição");
                project.setDescription(newDescription);
            }
            facade.updateProject(project);
        } catch (Exception e) {
            System.out.println("erro ao atualizar");
        }
        ExtensionsIO.addLn();
    }

    private void listProjectById() {
        ExtensionsIO.optionChose("Listar Project por Id");
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do Project: "));
        Project project = null;
        try {
            project = facade.getProject(actualUser.getId());
        } catch (NotFoundEntity e) {
            System.out.println(e.getMessage());
        }
        if (project != null)
            System.out.printf("Projeto: %s Id: %d%n", project.getName(), project.getId());
        ExtensionsIO.addLn();
    }
}
