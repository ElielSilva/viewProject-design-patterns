package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.FabricValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.IValidateAdapter;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;


public class UserService extends ServiceGeneric<User> {
    private static UserService InstanceUserService;
    private final IValidateAdapter validate;

    public static UserService getInstanceUserService() {
        if (InstanceUserService == null) {
            InstanceUserService = new UserService();
        }
        return InstanceUserService;
    }

    private UserService() {
        this.validate = FabricValidate.getValidate();
    }

    @Override
    protected void valid(User entity) throws DataContractValidate {
        if (!this.validate.IsValid(entity.getName(), entity.getEmail(), entity.getPassword())) {
            throw new DataContractValidate("Email or Password Invalid");
        }
    }
}
