package hu.ulyssys.java.course.maven.mbean.model;

import hu.ulyssys.java.course.maven.entity.AppUserRole;

public class LoggedInUserModel {
    private Long id;
    private String username;
    private AppUserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }
}
