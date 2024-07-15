package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;

import java.util.List;

public class ProjectService {
    public IDAO<Project> instance;

    public ProjectService() {
        Object User;
        instance =  new DAO<Project>();
    }

    public List<Project> getAllProject () {
        return instance.getAll();
    }

    public Project getProject (int id) {
        return instance.getById(id);
    }

    public boolean createProject (Project project) {
        instance.add(project);
        return true;
    }
}
