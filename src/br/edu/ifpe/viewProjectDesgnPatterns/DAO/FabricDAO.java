package br.edu.ifpe.viewProjectDesgnPatterns.DAO;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.EntityBase;


public class FabricDAO<T extends EntityBase> {

    public static <T extends EntityBase> IDAO<T> fabric() {
        return DAO.getInstance();
    }
}
