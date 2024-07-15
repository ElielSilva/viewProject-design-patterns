package br.edu.ifpe.viewProjectDesgnPatterns.DAO;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;

public class FabricDAO<T> {
    public static IDAO fabric() {
        return DAO.getInstance();
    }
}
