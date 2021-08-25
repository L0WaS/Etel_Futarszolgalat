package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.rest.model.FoodModel;
import hu.ulyssys.java.course.maven.util.FoodModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/food")
public class FoodRestService extends CoreRestService<Food, FoodModel> {

    @Inject
    private FoodModelMapperBean foodModelMapperBean;

    @Override
    protected void populateEntityFromModel(Food entity, FoodModel model) {
        foodModelMapperBean.populateEntityFromModel(entity, model);
    }

    @Override
    protected FoodModel createModelFromEntity(Food entity) {
        return foodModelMapperBean.createModelFromEntity(entity);
    }

    @Override
    protected Food initNewEntity() {
        return new Food();
    }
}
