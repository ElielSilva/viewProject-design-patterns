package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class BackendDecoretor implements IProjects{
    private final double VALUE = 3000.0;
    private final IProjects project;

    public BackendDecoretor(IProjects project) {
        this.project = project;
    }


    @Override
    public double getValue() {
        return project.getValue() + VALUE;
    }
}
