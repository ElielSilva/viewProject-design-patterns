package br.edu.ifpe.viewProjectDesgnPatterns.DAO;

import java.util.List;

public interface IDAO<T> {
    public T getById (int id);
    public List<T> getAll ();
    public boolean add(T entity);
    public void delete(int id);
    public T update(T entity);
}
