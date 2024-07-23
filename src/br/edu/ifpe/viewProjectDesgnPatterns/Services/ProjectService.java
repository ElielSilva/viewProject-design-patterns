package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.com.fluentvalidator.AbstractValidator;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Exceptions.NoSearchEntity;

import java.util.List;

public class ProjectService {
    public IDAO<Project> instance;
    public AbstractValidator<Project> validator;

    public ProjectService() {
        instance = FabricDAO.fabric();

    }

    public List<Project> getAllProject () {
        return instance.getAll();
    }

    public Project getProject (int id) throws NoSearchEntity {
        return instance.getById(id);
    }

    public boolean createProject (Project project) {
        instance.add(project);
        return true;
    }
}
