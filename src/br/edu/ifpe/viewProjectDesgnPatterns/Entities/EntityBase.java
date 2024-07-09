package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class EntityBase {
    public int id;

    public EntityBase(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
