package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class FrontendDecorator extends ProjectDecorator {
    public IProjects project;

    public FrontendDecorator(IProjects project) {
        super(project);
    }

    @Override
    public double getValue() {
        double VALUE = 2000.0;
        return super.getValue() + VALUE;
    }
}
