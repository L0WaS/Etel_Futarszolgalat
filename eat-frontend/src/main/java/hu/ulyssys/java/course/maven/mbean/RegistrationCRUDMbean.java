package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.service.AppUserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class RegistrationCRUDMbean extends CoreCRUDMbean<AppUser> implements Serializable {

    LoginRequestBean loginRequestBean;

    @Inject
    public RegistrationCRUDMbean(AppUserService appUserService, LoginRequestBean loginRequestBean){
        super(appUserService);
        this.loginRequestBean = loginRequestBean;
    }

    @Override
    protected String dialogName() {
        return "userDialog";
    }

    @Override
    protected AppUser initNewEntity() {
        return new AppUser();
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setPasswordHash(hashPassword(getSelectedEntity().getPasswordHash()));
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt mentés közben", ""));
            e.printStackTrace();
        }
    }

    public void registration(){
        loginRequestBean.getModel().setUsername(selectedEntity.getUserName());
        loginRequestBean.getModel().setPassword(selectedEntity.getPasswordHash());
        save();
        loginRequestBean.doLogin();
    }

    public void doLogin(){
        loginRequestBean.getModel().setUsername(selectedEntity.getUserName());
        loginRequestBean.getModel().setPassword(selectedEntity.getPasswordHash());
        System.out.println("Felhasznalonev: "+selectedEntity.getUserName());
        System.out.println("Jelszo: "+selectedEntity.getPasswordHash());
        System.out.println("Szerepkor: "+selectedEntity.getRole());
        loginRequestBean.doLogin();
        System.out.println("Bejelentkezes");
    }

    private String hashPassword(String rawPassword) {
        return DigestUtils.sha512Hex(rawPassword);
    }
}
