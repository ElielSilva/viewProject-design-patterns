package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public class User extends EntityBase {
    private String name;
    private String email;
    private String password;
    private Role role;

    public User(Build build) {
        super(build.id == null ? -1 : build.id );
        this.name = build.name;
        this.email = build.email;
        this.password = build.password;
        this.role = build.role;
    }

    public User clone() {
        return new User.Build()
                .id(super.getId())
                .name(this.getName())
                .email(this.getEmail())
                .password(this.getPassword())
                .role(this.getRole())
                .build();
    }

    @Override
    public String toString() {
        return "User = {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static class Build {
        private String name;
        private String email;
        private String password;
        private Role role;
        private Integer id;

        public Build name(String name) {
            this.name = name;
            return this;
        }

        public Build id(Integer id) {
            this.id = id;
            return this;
        }

        public Build email(String email) {
            this.email = email;
            return this;
        }

        public Build password(String password) {
            this.password = password;
            return this;
        }

        public Build role(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}