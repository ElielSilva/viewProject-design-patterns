package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class MobileDecorator extends Decorator{
    private final double VALUE = 2500.0;

    public MobileDecorator(IDecorator project) {
        super(project);
    }

    @Override
    public double getValue() {
        return super.project.getValue() + VALUE;
    }
}
