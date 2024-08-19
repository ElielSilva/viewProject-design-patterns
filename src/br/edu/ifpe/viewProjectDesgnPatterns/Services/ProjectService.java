package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.*;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Logger.Logger;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Logger.LoggerType;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.FabricValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Validator.IValidateAdapter;

import java.util.List;

public class ProjectService extends ServiceGeneric<Project> {
    private static ProjectService InstanceService;
    private final IValidateAdapter validate;
    private Logger logger;

    public static ProjectService getInstanceProjectService() {
        if (InstanceService == null) {
            InstanceService = new ProjectService();
        }
        return InstanceService;
    }

    private ProjectService() {
        this.validate = FabricValidate.getValidate();
        this.logger = Logger.getInstance();
    }

    public void decoratorProject(int id, String type) throws NotFoundEntity {
        Project project = this.get(id);
        logger.log("Decorating Project", LoggerType.INFO);
        IProjects projectDecorator = project;
        switch (type) {
            case "Frontend":
                projectDecorator = new FrontendDecorator(project);
                logger.log("Decorating Project with Frontend -> " + projectDecorator, LoggerType.INFO);
                break;
            case "Backend":
                projectDecorator = new BackendDecoretor(project);
                logger.log("Decorating Project with backend -> " + projectDecorator, LoggerType.INFO);
                break;
            case "Mobile":
                projectDecorator = new MobileDecorator(project);
                logger.log("Decorating Project with Mobile -> " + projectDecorator, LoggerType.INFO);
                break;
        }
        System.out.println(projectDecorator.toString());

    }

    @Override
    protected void valid(Project entity) throws DataContractValidate {
        if (!this.validate.IsValid(entity.getName())) {
            throw new DataContractValidate("Name or description Invalid");
        }
    }
}
