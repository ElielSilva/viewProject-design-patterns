package br.edu.ifpe.viewProjectDesgnPatterns.Decorator;

public class Mobile implements IProjects{
    private final double VALUE = 2500.0;
    private final IProjects project;

    public Mobile(IProjects project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return project.getValue() + VALUE;
    }
}
