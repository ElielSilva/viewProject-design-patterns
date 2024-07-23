package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationResult;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.AdapterValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.UserValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Apresentation.Apresentation;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static UserService InstanceUserService;
    public IDAO<User> instanceUserDAO;
    private  AdapterValidate InstanceUserValidate = new AdapterValidate();

    public static UserService getInstanceUserService() {
        if (InstanceUserService == null) {
            InstanceUserService = new UserService();
        }
        return InstanceUserService;
    }

    public UserService() {
        instanceUserDAO =  FabricDAO.fabric();
    }

    public List<User> getAllUser () {
        try{
            return instanceUserDAO.getAll();
        }
        catch (Exception e) {

            return new ArrayList<User>();
        }
    }

    public User getUser (int id) {
        try {
            return instanceUserDAO.getById(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }

    }

    public boolean createUser (User entity) throws Exception {
        try {
            boolean result = InstanceUserValidate.isValidate(entity.getName(), entity.getEmail(),entity.getPassword());
            if (result) {
                instanceUserDAO.add(entity);
                return true;
            }
            throw new Exception("Not Implemented");
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }

    public boolean add(User entity) {

        boolean result = InstanceUserValidate.isValidate(entity.getName(), entity.getEmail(),entity.getPassword());
        if (result) {
            instanceUserDAO.add(entity);
            return true;
        }
        return false;
    }

    public void delete(int id) throws Exception {
        try {
            instanceUserDAO.delete(id);
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }

    public User update(User entity) throws Exception {
        try {
            boolean result = InstanceUserValidate.isValidate(entity.getName(), entity.getEmail(),entity.getPassword());
            if (result) {
                return instanceUserDAO.update(entity);
            }
            return entity;
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }
}
