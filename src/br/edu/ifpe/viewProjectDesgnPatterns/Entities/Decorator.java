package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public abstract class Decorator implements IDecorator{
    public IDecorator project;

    public Decorator(IDecorator project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
