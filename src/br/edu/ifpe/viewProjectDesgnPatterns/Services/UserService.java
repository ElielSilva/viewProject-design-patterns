package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.EmailAndNameAndPasswordValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.FabricValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.Validate;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exceptions.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exceptions.NoSearchEntity;

import java.util.List;

public class UserService {
    public IDAO<User> instance;
    private final Validate validate;

    public UserService() {

        instance =  FabricDAO.fabric();
        this.validate = FabricValidate.getValidate();
    }

    public List<User> getAllUser () {
        return instance.getAll();
    }

    public User getUser (int id) {
        try{
            return instance.getById(id);
        } catch (NoSearchEntity e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createUser (User entity) throws DataContractValidate, Exception {
        try {
            boolean result = validate(entity)
            if (result) {
                instance.add(entity);
                return true;
            }
            throw new DataContractValidate("Falha na validação");
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }

    public boolean add(User entity) throws Exception {
        try {
            boolean result = validate.IsValid(entity.getName());
            if (result) {
                instance.add(entity);
                return true;
            }
            throw new DataContractValidate();
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

    private boolean validate(User e) {
        return validate.IsValid(e.getName(), e.getEmail(), e.getPassword());
    }

    public User update(User entity) throws Exception {
        try {
            boolean result = validate(entity);
            if (result) {
                return instance.update(entity);
            }
            return entity;
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }
}
