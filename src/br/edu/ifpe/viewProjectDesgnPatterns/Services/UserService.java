package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationResult;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.UserValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;

import java.util.List;

public class UserService {
    public IDAO<User> instance;
    private AbstractValidator<User> UserValidateInstance = new UserValidate();

    public UserService() {
        instance =  FabricDAO.fabric();
    }

    public List<User> getAllUser () {
        return instance.getAll();
    }

    public User getUser (int id) {
        try{
            return instance.getById(id);
        }catch (Exception e) {
            throw e;
        }
    }

    public boolean createUser (User entity) throws Exception {
        try {
            ValidationResult result = UserValidateInstance.validate(entity);
            if (result.isValid()) {
                instance.add(entity);
                return true;
            }
            throw new Exception(result.toString());
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }

    public boolean add(User entity) throws Exception {
        try {
            ValidationResult result = UserValidateInstance.validate(entity);
            if (result.isValid()) {
                instance.add(entity);
                return true;
            }
            throw new Exception(result.toString());
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }

    public void delete(int id) throws Exception {
        try {
            instance.delete(id);
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }

    public User update(User entity) throws Exception {
        try {
            ValidationResult result = UserValidateInstance.validate(entity);
            if (result.isValid()) {
                return instance.update(entity);
            }
            return entity;
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }
}
