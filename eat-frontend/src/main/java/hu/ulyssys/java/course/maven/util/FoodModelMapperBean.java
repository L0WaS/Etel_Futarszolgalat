package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.rest.model.FoodModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FoodModelMapperBean extends CoreModelMapperBean<FoodModel, Food> {
    @Override
    public FoodModel initNewModel() {
        return new FoodModel();
    }
    @Override
    public FoodModel createModelFromEntity(Food entity) {
        FoodModel foodModel = super.createModelFromEntity(entity);
        foodModel.setName(entity.getName());
        foodModel.setDescription(entity.getDescription());
        foodModel.setPrice(entity.getPrice());
        return foodModel;
    }

    @Override
    public void populateEntityFromModel(Food entity, FoodModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
    }
}