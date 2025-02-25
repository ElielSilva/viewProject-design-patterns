package br.edu.ifpe.viewProjectDesgnPatterns.Services;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.IDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.EntityBase;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.DataContractValidate;
import br.edu.ifpe.viewProjectDesgnPatterns.Exception.NotFoundEntity;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Logger.ILogger;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Logger.Logger;
import br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Logger.LoggerType;

import java.util.List;
import java.util.function.Predicate;

public abstract class ServiceGeneric<T extends EntityBase> implements IService<T> {

    private final IDAO<T> dao;
    private final ILogger logger;

    protected ServiceGeneric() {
        this.dao = FabricDAO.fabric();
        this.logger = Logger.getInstance();
    }

    public void add(T entity) {
        try {
            this.valid(entity);
            dao.add(entity);
            String message = "Adding entity" + entity.toString();
            this.logger.log(message, LoggerType.INFO);
        } catch (DataContractValidate e) {
            String message = "Error adding entity" + entity.toString() + " " + e.getMessage();
            this.logger.log(message, LoggerType.ERROR);
        }
    }

    public List<T> get() throws NotFoundEntity {
        return dao.getAll();
    }

    public T get(int id) throws NotFoundEntity {
        if (!dao.isExist(id)) {
            this.logger.log("Entity not found", LoggerType.ERROR);
            throw new NotFoundEntity("User Not Found");
        }
        return dao.getById(id);
    }

    public T search(Predicate<T> predicate) throws NotFoundEntity {
        T entity = dao.search(predicate);
        if (entity == null) {
            this.logger.log("Entity not found", LoggerType.ERROR);
            throw new NotFoundEntity("User Not Found");
        }
        return entity;
    }

    public void update(T entity) throws DataContractValidate, NotFoundEntity {
        try {
            this.valid(entity);
            dao.update(entity);
            String message = "Updating entity" + entity.toString();
            this.logger.log(message, LoggerType.INFO);
        } catch (DataContractValidate | NotFoundEntity e) {
            String message = "Error updating entity" + entity.toString() + " " + e.getMessage();
            this.logger.log(message, LoggerType.ERROR);
            throw e;
        }
    }

    public void delete(int id) throws NotFoundEntity {
        try {
            dao.delete(id);
            String message = "Deleting entity" + id;
            this.logger.log(message, LoggerType.INFO);
        } catch (NotFoundEntity e) {
            String message = "Error deleting entity" + id + " " + e.getMessage();
            this.logger.log(message, LoggerType.ERROR);
            throw e;
        }
    }

    protected abstract void valid(T entity) throws DataContractValidate;
}
