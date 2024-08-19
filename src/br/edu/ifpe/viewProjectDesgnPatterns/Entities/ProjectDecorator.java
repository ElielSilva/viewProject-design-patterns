package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public abstract class ProjectDecorator implements IProjects {
    private final double VALUE = 0.0;
    public IProjects project;

    public ProjectDecorator(IProjects project) {
        this.project = project;
    }

    @Override
    public double getValue() {
        return this.project.getValue() + VALUE;
    }

    @Override
    public String toString() {
        return "ProjectDecorator{" +
                "VALUE=" + VALUE +
                ", IProject=" + project +
                '}';
    }
}
