package br.edu.ifpe.viewProjectDesgnPatterns.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;

import java.util.List;
import java.util.function.Predicate;

public interface IDAO<T> {
    T getById (int id);
    List<T> getAll ();
    boolean add(T entity);
    void delete(int id) throws NotFoundEntity;
    T update(T entity) throws NotFoundEntity;
    T search(Predicate<T> predicate) throws NotFoundEntity;
    boolean isExist(int id);
}
