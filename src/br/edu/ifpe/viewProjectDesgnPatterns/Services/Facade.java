package br.edu.ifpe.viewProjectDesgnPatterns.Services;

import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Logger.LoggerType;

import java.util.List;
import java.util.function.Predicate;

public class Facade<T> {
    private IService<T> ServiceGeneric;

    public void add(T entity) {
        ServiceGeneric.add(entity);
    }

    public List<T> get() {
        return ServiceGeneric.get();
    }

    public T get(int id) throws NotFoundEntity {
        return ServiceGeneric.get(id);
    }

    public T search(Predicate<T> predicate) throws NotFoundEntity {

        return ServiceGeneric.search(predicate);
    }

    public void update(T entity) throws DataContractValidate, NotFoundEntity {
        ServiceGeneric.update(entity);
    }

    public void delete(int id) throws NotFoundEntity {
        ServiceGeneric.delete(id);
    }
}
