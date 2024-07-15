import br.edu.ifpe.viewProjectDesgnPatterns.DAO.DAO;
import br.edu.ifpe.viewProjectDesgnPatterns.DAO.FabricDAO;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //a.createUser(new User().Builder().name())
        User u = new User.Build().Id(1).Name("Eliel").Email("a@a.com").Password("123").Role("cleint").build();
        UserService a = new UserService();
        a.createUser(u);

        System.out.printf(u.getName());
        System.out.printf(a.getAllUser().getFirst().getName());


    }
}