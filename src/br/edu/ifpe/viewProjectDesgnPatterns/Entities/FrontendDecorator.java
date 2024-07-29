package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class FrontendDecorator implements IProjects {
    private final double VALUE = 2000.0;
    private IProjects project;

    public FrontendDecorator(IProjects project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return this.project.getValue() + VALUE;
    }
}
