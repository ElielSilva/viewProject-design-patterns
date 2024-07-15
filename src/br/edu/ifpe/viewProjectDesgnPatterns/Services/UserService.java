package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;

import java.util.List;

public class UserService {
    public IDAO<User> instance;


    public UserService() {
        instance =  FabricDAO.fabric();
    }

    public List<User> getAllUser () {
        return instance.getAll();
    }

    public User getUser (int id) {
        return instance.getById(id);
    }

    public boolean createUser (User user) {
        instance.add(user);
        return true;
    }
}
