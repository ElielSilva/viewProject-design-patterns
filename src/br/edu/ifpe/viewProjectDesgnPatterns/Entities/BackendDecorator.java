package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class BackendDecorator extends Decorator{
    private final double VALUE = 3000.0;

    public BackendDecorator(IDecorator project) {
        super(project);
    }

    @Override
    public double getValue() {
        return super.project.getValue() + VALUE;
    }

    @Override
    public String toString() {
        return "BackendDecoretor{" +
                "VALUE=" + this.getValue() +
                ", project=" + project +
                '}';
    }
}
