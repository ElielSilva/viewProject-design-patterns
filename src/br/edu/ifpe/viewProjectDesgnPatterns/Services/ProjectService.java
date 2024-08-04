package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.FabricValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.IValidateAdapter;

import java.util.List;

public class ProjectService extends ServiceGeneric<Project> {
    private static ProjectService InstanceService;
    private final IValidateAdapter validate;

    public static ProjectService getInstanceProjectService() {
        if (InstanceService == null) {
            InstanceService = new ProjectService();
        }
        return InstanceService;
    }

    private ProjectService() {
        this.validate = FabricValidate.getValidate();
    }

    @Override
    protected void valid(Project entity) throws DataContractValidate {
        if (!this.validate.IsValid(entity.getName())) {
            throw new DataContractValidate("Nome ou descrição Invalido");
        }
    }
}
