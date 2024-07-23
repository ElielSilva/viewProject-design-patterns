package br.edu.ifpe.viewProjectDesgnPatterns.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;

import java.util.List;
import java.util.function.Predicate;

public interface IDAO<T> {
    public T getById (int id);
    public List<T> getAll ();
    public boolean add(T entity);
    public void delete(int id);
    public T update(T entity);
    T search(Predicate<T> predicate) throws NotFoundEntity;
    boolean IsExist(int id);
}
