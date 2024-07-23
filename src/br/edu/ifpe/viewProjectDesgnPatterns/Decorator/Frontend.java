package br.edu.ifpe.viewProjectDesgnPatterns.Decorator;

public class Frontend implements IProjects {
    private final double VALUE = 2000.0;
    private IProjects project;

    public Frontend(IProjects project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return this.project.getValue() + VALUE;
    }
}
