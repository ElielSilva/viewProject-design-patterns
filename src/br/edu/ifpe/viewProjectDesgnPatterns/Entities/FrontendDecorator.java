package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class FrontendDecorator extends Decorator {
    private final double VALUE = 2000.0;

    public FrontendDecorator(Project project) {
        super(project);
    }

    @Override
    public double getValue() {
        return super.project.getValue() + VALUE;
    }

    @Override
    public String toString() {
        return "FrontendDecorator{" +
                "project=" + project +
                ", VALUE=" + VALUE +
                '}';
    }
}
