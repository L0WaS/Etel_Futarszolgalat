package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AppUserRole;
import hu.ulyssys.java.course.maven.mbean.model.LoggedInUserModel;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoggedInUserBean implements Serializable {

    private LoggedInUserModel model;

    public LoggedInUserModel getModel() {
        return model;
    }

    public void setModel(LoggedInUserModel model) {
        this.model = model;
    }

    public boolean isLoggedIn() {
        return model != null;
    }

    public boolean isAdmin() {
        return isLoggedIn() && model.getRole().equals(AppUserRole.ADMIN);
    }
}
