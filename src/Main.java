import br.edu.ifpe.viewProjectDesgnPatterns.Apresentation.Presentation;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Project;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.ProjectService;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService a = UserService.getInstanceUserService();
        User testElielAdmin = new User.Build().name("eliel").email("a@a.com").password("#Ee123").role(Role.ADMIN).build();
        User testJunioAdmin = new User.Build().name("junio").email("j@j.com").password("#Jj123").role(Role.ADMIN).build();
        a.add(testElielAdmin);
        a.add(testJunioAdmin);

        Presentation app = Presentation.getinstaceApresentationUnique();
        app.DesktopScreen();
    }
}