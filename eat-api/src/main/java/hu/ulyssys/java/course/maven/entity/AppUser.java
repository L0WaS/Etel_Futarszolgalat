package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;

@NamedQuery(name = AppUser.FIND_BY_USERNAME, query = "select u from AppUser u where u.userName=:username ")
@Entity
@Table(name = "appuser")
public class AppUser extends AbstractEntity{

    public static  final String FIND_BY_USERNAME = "AppUser.findByUsername";

    @Column(name = "user_name", unique = true, nullable = false, length = 200)
    private String userName;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private AppUserRole role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        if (getId() != null ? !getId().equals(appUser.getId()) : appUser.getId() != null) return false;
        return userName != null ? userName.equals(appUser.userName) : appUser.userName == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
