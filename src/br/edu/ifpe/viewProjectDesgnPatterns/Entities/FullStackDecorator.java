package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class FullStackDecorator implements IProjects{
    private final double VALUE = 5000.0;
    private final IProjects project;

    public FullStackDecorator(IProjects project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return project.getValue() + VALUE;
    }
}
