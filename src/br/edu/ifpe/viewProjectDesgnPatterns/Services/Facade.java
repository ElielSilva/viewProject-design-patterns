package br.edu.ifpe.viewProjectDesgnPatterns.Services;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;

import java.util.List;
import java.util.function.Predicate;

public class Facade {
    private UserService userService = UserService.getInstanceUserService();
    private ProjectService projectService = ProjectService.getInstanceProjectService();

    public void addUser(User entity) {
        userService.add(entity);
    }

    public List<User> getUser() {
        return userService.get();
    }

    public User getUser(int id) throws NotFoundEntity {
        return userService.get(id);
    }

    public User searchUser(Predicate<User> predicate) throws NotFoundEntity {
        return userService.search(predicate);
    }

    public void updateUser(User entity) throws DataContractValidate, NotFoundEntity {
        userService.update(entity);
    }

    public void deleteUser(int id) throws NotFoundEntity {
        userService.delete(id);
    }

    public void addProject(Project entity) {
        projectService.add(entity);
    }

    public List<Project> getProject() {
        return projectService.get();
    }

    public Project getProject(int id) throws NotFoundEntity {
        return projectService.get(id);
    }

    public Project searchProject(Predicate<Project> predicate) throws NotFoundEntity {

        return projectService.search(predicate);
    }

    public void updateProject(Project entity) throws DataContractValidate, NotFoundEntity {
        projectService.update(entity);
    }

    public void deleteProject(int id) throws NotFoundEntity {
        projectService.delete(id);
    }
}
