package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class MobileDecorator implements IProjects{
    private final double VALUE = 2500.0;
    private final IProjects project;

    public MobileDecorator(IProjects project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return project.getValue() + VALUE;
    }
}
