package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class DatabaseDecorator extends Decorator{
    private final double VALUE = 1500.0;;

    public DatabaseDecorator(IDecorator project) {
        super(project);
    }

    @Override
    public double getValue() {
        return super.project.getValue() + VALUE;
    }

    @Override
    public String toString() {
        return "DatabaseDecorator{" +
                "VALUE=" + this.getValue() +
                ", project=" + project +
                '}';
    }
}
