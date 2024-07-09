package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(Build build) {
        this.name = build.name;
        this.email = build.email;
        this.password = build.password;
        this.role = build.role;
        this.id = build.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public class Build {
        private Integer id;
        private String name;
        private String email;
        private String password;
        private String role;

        public Build setId(Integer id) {
            this.id = id;
            return this;
        }

        public Build setName(String name) {
            this.name = name;
            return this;
        }

        public Build setEmail(String email) {
            this.email = email;
            return this;
        }

        public Build setPassword(String password) {
            this.password = password;
            return this;
        }

        public Build setRole(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}