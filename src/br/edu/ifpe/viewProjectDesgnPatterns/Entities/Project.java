package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

import java.time.LocalDate;

public class Project extends EntityBase implements IProjects {
    private final Double VALUE = 0.0;

    private String name;
    private String description;
    private String status; // criar enum
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer userId;

    public Project(Build build) {
        super(build.id == null ? -1 : build.id);
        this.name = build.name;
        this.description = build.description;
        this.status = build.status;
        this.startDate = build.startDate;
        this.endDate = build.endDate;
        this.userId = build.userId;
    }

    @Override
    public String toString() {
        return "Project = {" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", userId=" + userId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDateDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    @Override
    public double getValue() {
        return VALUE;
    }

    public static class Build {
        private Integer id;
        private String name;
        private String description;
        private String status;
        private LocalDate startDate;
        private LocalDate endDate;
        private Integer userId;

        public Build id(Integer id) {
            this.id = id;
            return this;
        }

        public Build name(String name) {
            this.name = name;
            return this;
        }

        public Build description(String description) {
            this.description = description;
            return this;
        }

        public Build Status(String status) {
            this.status = status;
            return this;
        }

        public Build startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Build endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Build userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }
}
