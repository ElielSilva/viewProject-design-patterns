package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Utils;

import java.util.Scanner;

public class ExtensionsIO {

    public static void addLn() {
        System.out.println("\n");
        System.out.println("\n");
    }

    public static void optionChose(String option) {
        String chosenOption = "############################### " + option.toUpperCase() +
                " ###############################";

        StringBuilder ln = new StringBuilder();
        ln.append("#".repeat(chosenOption.length()));
        addLn();
        System.out.println(ln);
        System.out.println(chosenOption);
        System.out.println(ln);
        addLn();
    }

    public static Integer getInputInt(String prompt) {
        int output = 0;
        try {
            System.out.println(prompt.toUpperCase());
            output = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (Exception e) {
            System.out.println("ERRO VALOR INVALIDO");
            addLn();
            getInput(prompt);
        }
        return  output;
    }

    public static String getInput(String prompt) {
        System.out.println(prompt.toUpperCase());
        return new Scanner(System.in).nextLine();
    }
}
