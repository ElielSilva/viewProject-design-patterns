package br.edu.ifpe.viewProjectDesgnPatterns.DAO;

import java.util.List;

public interface IDAO<T> {
    public T get (int id, T type);
    public List<T> getAll (T type);
    public boolean add(T entity);
    public void delete(int id, T type);
    public T update(T entity);
}
