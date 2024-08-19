package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.FabricValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.IValidateAdapter;

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
            throw new DataContractValidate("Name or description Invalid");
        }
    }
}
