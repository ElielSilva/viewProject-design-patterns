package br.edu.ifpe.viewProjectDesgnPatterns.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.EntityBase;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DAO<T extends EntityBase> implements IDAO<T> {
    private  ArrayList<T> database = new ArrayList<T>();
    private int lastId = 0;
    
    public static <T extends EntityBase> DAO<T> getInstance() {
        return new DAO<T>();
    }

    @Override
    public T getById(int id) {
        return (T) database
            .stream()
            .filter(data -> data.getId() == id).findFirst().orElseThrow();
    }

    @Override
    public List<T> getAll() {
        if (database.isEmpty()) {
            throw new RuntimeException("database is empty");
        }
        return database;
    }

    @Override
    public boolean add(T entity)  {
        int lengthInitialList = database.size();
        if (entity.getId() == -1) {
            this.lastId = database.size() + 1;
            entity.setId(lastId);
        }
        database.addLast(entity);
        return lengthInitialList != database.size();
    }

    @Override
    public void delete(int id) throws NotFoundEntity {
        boolean isExist = this.isExist(id);
        if (!isExist)
            throw new NotFoundEntity("Entidade não encontrada");
        database.removeIf(data -> data.getId() == id);
    }

    @Override
    public T update(T entity) throws NotFoundEntity {
        int id = entity.getId();
        this.delete(entity.getId());
        this.add(entity);
        return entity;
    }

    @Override
    public T search(Predicate<T> predicate) throws NotFoundEntity {
        return database
                .stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(() -> new NotFoundEntity("Entidate não encontrada"));
    }

    @Override
    public boolean isExist(int id) {
        return database.stream().anyMatch(x -> x.getId() == id);
    }
}
