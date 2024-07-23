package br.edu.ifpe.viewProjectDesgnPatterns.Decorator;

public class Backend implements IProjects{
    private final double VALUE = 3000.0;
    private final IProjects project;

    public Backend(IProjects project) {
        this.project = project;
    }


    @Override
    public double getValue() {
        return project.getValue() + VALUE;
    }
}
