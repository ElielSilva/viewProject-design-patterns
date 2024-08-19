package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public abstract class Decorator implements IDecorator{
    public Project project;

    public Decorator(Project project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
