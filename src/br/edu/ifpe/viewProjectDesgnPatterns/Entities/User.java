package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class User extends EntityBase {
//    private Integer id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public User(Build build) {
//        super(build.id);
        this.name = build.name;
        this.email = build.email;
        this.password = build.password;
        this.role = build.role;
//        this.id = build.id;
    }

//    public Integer getId() {
//        return id;
//    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static class Build {
//        private Integer id;
        private String name;
        private String email;
        private String password;
        private Role role;

//        public Build Id(Integer id) {
//            this.id = id;
//            return this;
//        }

        public Build Name(String name) {
            this.name = name;
            return this;
        }

        public Build Email(String email) {
            this.email = email;
            return this;
        }

        public Build Password(String password) {
            this.password = password;
            return this;
        }

        public Build Role(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}