package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class FrontendDecorator extends Decorator {
    private final double VALUE = 2000.0;

    public FrontendDecorator(IDecorator project) {
        super(project);
    }

    @Override
    public double getValue() {
        return super.project.getValue() + VALUE;
    }

    @Override
    public String toString() {
        return "FrontendDecorator{" +
                "VALUE=" + this.getValue() +
                ", project=" + project +
                '}';
    }
}
