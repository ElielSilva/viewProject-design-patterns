package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class FullStackDecorator extends ProjectDecorator {

    public FullStackDecorator(IProjects project) {
        super(project);
    }

    @Override
    public double getValue() {
        double VALUE = 5000.0;
        return super.getValue() + VALUE;
    }
}
