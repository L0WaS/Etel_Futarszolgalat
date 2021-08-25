package hu.ulyssys.java.course.maven.mbean;


import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@Named
@ViewScoped
public class CourierCRUDMbean extends AwareCRUDMbean<Courier> implements Serializable {
    @Inject
    public CourierCRUDMbean(CourierService courierService, AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(courierService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isAdmin()){
            throw new SecurityException("Nincs elég jogosúltságod!");
        }
    }

    @Override
    public void save() {
        if (!selectedEntity.getLastName().equals(selectedEntity.getFirstName())){
            super.save();
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A vezetéknévnek és a vezetéknévnek különböznie kell", ""));
        }
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
