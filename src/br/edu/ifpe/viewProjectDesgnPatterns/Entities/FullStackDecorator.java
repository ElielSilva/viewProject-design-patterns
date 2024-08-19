package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class FullStackDecorator implements IDecorator{
    private final double VALUE = 5000.0;
    private final IDecorator project;

    public FullStackDecorator(IDecorator project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return project.getValue() + VALUE;
    }
}
