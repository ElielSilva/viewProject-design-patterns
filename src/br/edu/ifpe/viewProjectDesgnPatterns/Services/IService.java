package br.edu.ifpe.viewProjectDesgnPatterns.Services;

import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;

import java.util.List;
import java.util.function.Predicate;

public interface IService<T> {
    void add(T entity);
    List<T> get() throws NotFoundEntity;
    T get(int id) throws NotFoundEntity;
    T search(Predicate<T> predicate) throws NotFoundEntity;
    void update(T entity) throws NotFoundEntity, DataContractValidate;
    void delete(int id) throws NotFoundEntity;
}
