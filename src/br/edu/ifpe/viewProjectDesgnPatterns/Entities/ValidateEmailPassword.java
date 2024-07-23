package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class ValidateEmailPassword extends ValidateName {

    private String Email;
    private String Password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public ValidateEmailPassword(String name, String email, String password) {
        super(name);
        Email = email;
        Password = password;
    }
}
