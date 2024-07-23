package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.FabricValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Adapter.IValidateAdapter;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;

import java.util.List;

public class UserService {
    public IDAO<User> instance;
    private static UserService InstanceUserService;
    private IValidateAdapter validate;

    public static UserService getInstanceUserService() {
        if (InstanceUserService == null) {
            InstanceUserService = new UserService();
        }
        return InstanceUserService;
    }


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
        }catch (Exception e) {
            throw e;
        }
    }

    private boolean valid(User u) {
        return validate.IsValid(u.getName(), u.getEmail(), u.getPassword());
    }

    public boolean createUser (User entity) throws Exception {
        try {
            if (valid(entity)) {
                instance.add(entity);
                return true;
            }
            throw new DataContractValidate("Dados invalidos");
        }catch (Exception e) {
            throw new Exception("Not Implemented");
        }
    }

    public boolean add(User entity) throws Exception {
        try {
            if (valid(entity)) {
                instance.add(entity);
                return true;
            }
            throw new DataContractValidate("Dados invalidos");
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



    public User update(User entity) throws NotFoundEntity, DataContractValidate {
        if (valid(entity)) {
            if (instance.IsExist(entity.id)) {
                return instance.update(entity);
            }
            throw new NotFoundEntity("Usuario Não encontrado");
        } else {
            throw new DataContractValidate("Dados invalidos");
        }
    }
}
