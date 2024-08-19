package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.*;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.Unauthorized;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.Facade;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsBuilds;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsIO;

import java.util.Arrays;
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
            opcao = Integer.parseInt(ExtensionsIO.getInput("Digite a opção desejada: "));
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
                /*case 6:
                    this.decorateProject();
                    break;*/
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }
        }
    }

   /* private void decorateProject() {
        // como posso decorar um projeto e depois salvar no dao?
        ExtensionsIO.optionChose("decorar Projetos");
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do Project: "));
        int opt = Integer.parseInt(ExtensionsIO.getInput("COMO DESEJA DECORAR ESSE PROJETO:\n\n1 - FrontEnd\n2 - BackEnd\n3 - FullStack\n4 - Mobile"));
        try {
            Project project = facade.getProject(id);
            switch (opt){
                case 1:
                    //project = new FrontendDecorator(project);
                    break;
                case 2:
                    //project = new BackendDecoretor(project);
                    break;
                case 3:
                    //project = new FullStackDecorator(project);
                    break;
                case 4:
                    //project = new MobileDecorator(project);
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }

            System.out.println(project);
            //Project n = (Project) ((FrontendDecorator) project).project;

            //facade.updateProject(n);

        } catch (NotFoundEntity e) {
            System.out.println("Projeto não existe.");
        } catch (DataContractValidate e) {
            throw new RuntimeException(e);
        }
    }*/

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
        List<Project> allProject = null;
        try {
            allProject = facade.getProject();
            if (allProject.isEmpty()) {
                System.out.println("não há Projetos");
            }
            allProject.forEach(
                    p -> {
                        if (p.getProjectTypes().length != 0) {
                            Arrays.stream(p.getProjectTypes()).forEach(
                                    t -> {
                                        if (t.equals(ProjectTypes.FRONTEND)) {
                                            new FrontendDecorator(p);
                                        } else if (t.equals(ProjectTypes.BACKEND)) {
                                            new FrontendDecorator(p);
                                        } else if (t.equals(ProjectTypes.DATABASE)) {
                                            new FrontendDecorator(p);
                                        }

                                    }

                            );
                            System.out.println(p);
                        }
                        else {
                            System.out.println(p);
                        }
                    }
            );
            ExtensionsIO.addLn();
        } catch (NotFoundEntity e) {
            System.out.println("Ainda não existe registros de projetos inseridos na base");
        }
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
            System.out.println("deletado com sucesso");
            ExtensionsIO.addLn();
        } catch (NotFoundEntity | Unauthorized e) {
            System.out.println("erro ao deletar Projeto");
        }
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
            System.out.println(project);
        } catch (NotFoundEntity e) {
            System.out.println(e.getMessage());
        }
        ExtensionsIO.addLn();
    }
}
