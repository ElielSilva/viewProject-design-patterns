package br.edu.ifpe.viewProjectDesgnPatterns.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.EntityBase;

import java.util.ArrayList;
import java.util.List;

public class DAO<T extends EntityBase> implements IDAO<T> {
    private  List<T> database = new ArrayList<T>();


    public static <T extends EntityBase> DAO<T> getInstance() {
        
        return new DAO<T>();
    }

    @Override
    public T getById(int id) {
        var userResult = (T) database
            .stream()
            .filter(user -> user.getId() == id).toList().get(0);
        if (userResult == null) {
            throw new RuntimeException("User not found");
        }
        return userResult;
    }

    @Override
    public List<T> getAll() {
        if (database.isEmpty()) {
            throw new RuntimeException("database is empty");
        }
        return (List<T>) database;
    }

    @Override
    public boolean add(T entity) {
        int lengthInitialList = database.size();
        database.add(entity);
        return lengthInitialList != database.size();
    }

    @Override
    public void delete(int id) {
        database = database.stream().filter(u -> u.getId() != id).toList();
        return;
    }

    @Override
    public T update(T entity) {
        int id = entity.getId();
        delete(id);
        database.add(entity);
        return entity;
    }
}
