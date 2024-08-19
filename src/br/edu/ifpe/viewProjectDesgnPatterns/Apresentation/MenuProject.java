package br.edu.ifpe.viewProjectDesgnPatterns.Apresentation;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.*;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.Unauthorized;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.Facade;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsBuilds;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils.ExtensionsIO;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MenuProject {
    public Facade facade = new Facade();
    private User actualUser;
    private static final String MENU = "Enter Opção \n" + "0 - voltar\n1 - adicionar\n2 - listar Projetos\n3 - Listar Projetos por id\n4 - deletar Projetos\n5 - modificar Projetos";

    public void showMenuProject(User actualUser) {
        this.actualUser = actualUser;
        int opcao = -1;
        while (opcao != 0) {
            System.out.println(MENU.toUpperCase());
            opcao = Integer.parseInt(ExtensionsIO.getInput("Digite a opção desejada: "));
            switch (opcao) {
                case 0:
                    ExtensionsIO.optionChose("VOLTAR");
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
        ExtensionsIO.addLn();
        try {
            facade.addProject(ExtensionsBuilds.createNewProject().userId(actualUser.id).build());
        } catch (Exception e) {
            System.out.println("erro ao adicionar");
        }
        System.out.println("adicionado com sucesso");
        ExtensionsIO.addLn();
    }

    private void listProject() {
        ExtensionsIO.optionChose("Listar todos os Projetos");
        ExtensionsIO.addLn();
        List<Project> allProject = null;
        try {
            allProject = facade.getProject();
            if (allProject.isEmpty()) {
                System.out.println("não há Projetos");
            }
            allProject.forEach(this::printProjectDecorator);
        } catch (NotFoundEntity e) {
            System.out.println("Ainda não existe registros de projetos inseridos na base");
        }
        ExtensionsIO.addLn();
    }

    private void deleteProject() {
        ExtensionsIO.optionChose("Deletar Projeto");
        ExtensionsIO.addLn();
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do projeto"));
        try {
            if (actualUser.getRole() == Role.ADMIN) {
                facade.deleteProject(id);
            } else {
                Project project = facade.getProject(id);
                if (project.getUserId() != actualUser.getId()) {
                    throw new Unauthorized();
                }
                facade.deleteProject(id);
            }
            System.out.println("deletado com sucesso".toUpperCase());
        } catch (NotFoundEntity e) {
            System.out.println("erro ao deletar Projeto".toUpperCase());
        } catch (Unauthorized e) {
            System.out.println("Não possui permissão".toUpperCase());
        }
        ExtensionsIO.addLn();
    }

    private void updateProject() {
        ExtensionsIO.optionChose("Atualizar Projeto");
        ExtensionsIO.addLn();
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do Project: "));
        try {
            Project project = facade.getProject(id);
            if (actualUser.getRole() == Role.ADMIN) {
                project = ExtensionsBuilds.createNewProject().id(project.id).userId(actualUser.id).build();
            } else {
                if (project.getUserId() != actualUser.getId()) {
                    throw new Unauthorized();
                }
                project = ExtensionsBuilds.createNewProject().id(project.id).userId(actualUser.id).build();
            }
            facade.updateProject(project);
        } catch (Exception e) {
            System.out.println("erro ao atualizar");
        }
        ExtensionsIO.addLn();
    }

    private void listProjectById() {
        ExtensionsIO.optionChose("Listar Project por Id");
        ExtensionsIO.addLn();
        int id = Integer.parseInt(ExtensionsIO.getInput("Digite o id do Project: "));
        Project project = null;
        try {
            project = facade.getProject(id);
            this.printProjectDecorator(project);
        } catch (NotFoundEntity e) {
            System.out.println(e.getMessage());
        }
        ExtensionsIO.addLn();
    }

    private void printProjectDecorator(Project p) {
        AtomicReference<IDecorator> copyP = new AtomicReference<>(p);
        if (!p.getProjectTypes().isEmpty()) {
            p.getProjectTypes().forEach(
                    t -> {
                        if (t.equals(ProjectTypes.FRONTEND)) {
                            copyP.set(new FrontendDecorator(copyP.get()));
                        } else if (t.equals(ProjectTypes.BACKEND)) {
                            copyP.set(new BackendDecorator(copyP.get()));
                        } else if (t.equals(ProjectTypes.DATABASE)) {
                            copyP.set(new DatabaseDecorator(copyP.get()));
                        }
                    }
            );
            System.out.println(copyP);
        } else {
            System.out.println(p);
        }
    }
}
