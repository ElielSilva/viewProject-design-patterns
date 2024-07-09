package br.edu.ifpe.viewProjectDesgnPatterns.DAO;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.EntityBase;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DAO<T extends EntityBase> implements IDAO<T> {
    private  List<User> Users = new ArrayList<User>();
    private  List<Project> Projects = new ArrayList<Project>();

    private static DAO instance;

    public static DAO getInstance() {
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    @Override
    public T get(int id, T type) {
        if (type instanceof User user) {
            return (T) Users.stream().filter(u -> u.getId() == id).toList().get(0);
        }
        return (T) Projects.stream().filter(p -> p.getId() == id).toList().get(0);
    }

    public List<T> getAll(T type) {
        if (type instanceof User user) {
            return (List<T>) Users;
        }
        return (List<T>) Projects;
    }

    @Override
    public boolean add(T entity) {
        if(entity instanceof User user) {
            int lengthInitialList = Users.size();
            Users.add(user);
            return lengthInitialList != Users.size() ;
        };
        int lengthInitialList = Projects.size();
        Projects.add((Project) entity);
        return lengthInitialList != Projects.size() ;
    }

    @Override
    public void delete(int id, T type) {
        if(type instanceof User user) {
            Users = Users.stream().filter(u -> u.getId() != id).toList();
            return;
        };
        Projects = Projects.stream().filter(u -> u.getId() != id).toList();
    }

    @Override
    public T update(T entity) {
        int id = entity.getId();
        delete(id, entity);
        if(entity instanceof User user) {
            Users.add(user);
            return entity;
        };
        Projects.add((Project) entity);
        return entity;
    }
}
