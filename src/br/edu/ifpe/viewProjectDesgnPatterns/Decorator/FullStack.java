package br.edu.ifpe.viewProjectDesgnPatterns.Decorator;

public class FullStack implements IProjects{
    private final double VALUE = 5000.0;
    private final IProjects project;

    public FullStack(IProjects project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return project.getValue() + VALUE;
    }
}
