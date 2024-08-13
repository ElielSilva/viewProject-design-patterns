package br.edu.ifpe.viewProjectDesgnPatterns.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.EntityBase;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DAO<T extends EntityBase> implements IDAO<T> {
    private  List<T> database = new ArrayList<T>();
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
        return (List<T>) database;
    }

    @Override
    public boolean add(T entity)  {
        //Optional<Predicate<T>> ln = Optional.ofNullable(predicate);
        //if(ln.isPresent()){
        //    boolean entityExist = database
        //            .stream()
         //           .anyMatch(predicate);
        //    if(entityExist){
        //        throw new Exception();
        //    };
        //};

        int lengthInitialList = database.size();
        this.lastId = database.size() + 1;
        entity.setId(lastId);
        database.add(entity);
        return lengthInitialList != database.size();
    }

    @Override
    public void delete(int id) throws NotFoundEntity {
        if (!this.isExist(id))
            throw new NotFoundEntity("Entidade não encontrada");
        database = database.stream().filter(data -> data.getId() != id).toList();
    }

    @Override
    public T update(T entity) throws NotFoundEntity {
        int id = entity.getId();
        delete(id);
        database.add(entity);
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
