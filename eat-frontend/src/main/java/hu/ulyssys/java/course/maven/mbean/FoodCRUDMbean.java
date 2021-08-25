package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.FoodService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class FoodCRUDMbean extends AwareCRUDMbean<Food> implements Serializable {
    @Inject
    public FoodCRUDMbean(FoodService pizzaService, AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(pizzaService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isLoggedIn()){
            throw new SecurityException("Jelentkezz be az oldal használatához!");
        }
    }

    @Override
    protected String dialogName() {
        return "foodDialog";
    }

    @Override
    protected Food initNewEntity() {
        return new Food();
    }

}
