package hu.ulyssys.java.course.maven.converter;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.service.FoodService;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FoodConverter implements Converter {
    @Inject
    private FoodService foodService;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        return foodService.findByUserName(s);

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Food) {
            return ((Food) o).getName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}