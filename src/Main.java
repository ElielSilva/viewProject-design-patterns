import br.edu.ifpe.viewProjectDesgnPatterns.Apresentation.Presentation;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.*;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.ProjectService;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;

import java.util.ArrayList;

import static br.edu.ifpe.viewProjectDesgnPatterns.Entities.ProjectTypes.*;

public class Main {
    public static void main(String[] args) {
        ProjectService p = ProjectService.getInstanceProjectService();
        UserService a = UserService.getInstanceUserService();
        User testElielAdmin = new User.Build().name("eliel").email("a@a.com").password("#Ee123").role(Role.ADMIN).build();
        User testJunioAdmin = new User.Build().name("junio").email("j@j.com").password("#Jj123").role(Role.ADMIN).build();
        a.add(testElielAdmin);
        a.add(testJunioAdmin);

        ArrayList arr = new ArrayList<>();
        arr.add(ProjectTypes.FRONTEND);
        arr.add(ProjectTypes.BACKEND);

        p.add(new Project.Build().id(1).name("aaaaaa").description("aaaaaaaa").userId(3).build());
        p.add(new Project.Build().id(2).name("bbbbbbb").description("bbbbbbbbb").projectTypes(
                arr
         ).userId(3).build());

        System.out.println(
                new BackendDecorator(new FrontendDecorator(new Project.Build().id(1).name("aaaaaa").description("aaaaaaaa").userId(3).build()))
        );


        Presentation app = Presentation.getinstaceApresentationUnique();
        app.DesktopScreen();
    }
}