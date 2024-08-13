import br.edu.ifpe.viewProjectDesgnPatterns.Apresentation.Presentation;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.Role;
import br.edu.ifpe.viewProjectDesgnPatterns.Entities.User;
import br.edu.ifpe.viewProjectDesgnPatterns.Services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //a.createUser(new User().Builder().name())

        //  Project p = new Project.Build().Id(2).Name("jaaaa").StartDate(LocalDate.parse("2000-01-01")).build();
////        ProjectValidate x = new ProjectValidate();
//        var resultValidator = x.validate(p);
//        System.out.println(resultValidator);
//        UserService a = new UserService();
//        a.createUser(u);


        //User u = new User.Build().Id(1).Name("Eliel").Email("aaa.com").Password("123").Role("cleint").build();
        // UserValidate U = new UserValidate();
        //var UU = U.validate(u);

        //       System.out.println("UU");

        //  System.out.println(UU);
        //System.out.printf(a.getAllUser().getFirst().getName());

        //Scanner Input = new Scanner(System.in);  // Create a Scanner object
        //System.out.println("Enter Opção");

        //int opcao = -1;  // Read user input

        //while (opcao != 0) {
        // opcao = Input.nextInt();
        //   switch (opcao) {
        //        case 1:

        //   }
        ////}
        UserService a = UserService.getInstanceUserService();
        User TestElielAdmin = new User.Build().name("eliel").email("a@a.com").password("#Ee123").role(Role.ADMIN).build();
        User TestJunioAdmin = new User.Build().name("junio").email("j@j.com").password("#Jj123").role(Role.ADMIN).build();
        a.add(TestElielAdmin);
        a.add(TestJunioAdmin);

        Presentation app = Presentation.getinstaceApresentationUnique();
        app.DesktopScreen();
    }
}