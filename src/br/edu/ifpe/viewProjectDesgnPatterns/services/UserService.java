package br.edu.ifpe.viewProjectDesgnPatterns.services;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;

import java.util.List;

public class UserService {
    public IDAO<User> instance;

    public UserService() {
        Object User;
        instance =  new DAO<User>();
    }

    public List<User> getAllUser () {
        return instance.getAll();
    }

    public User getUser (int id) {
        return instance.getUser(id);
    }

    public boolean createUser (User user) {
        instance.add(user);
        return true;
    }
}
