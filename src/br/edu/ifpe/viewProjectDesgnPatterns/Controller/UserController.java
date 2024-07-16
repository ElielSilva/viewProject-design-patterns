package br.edu.ifpe.viewProjectDesgnPatterns.Controller;

import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;

public class UserController {
    private UserService userService = new UserService();

    public String getById (int id) {
        try{
            User user = userService.getUser(id);
            return user.getName();
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
