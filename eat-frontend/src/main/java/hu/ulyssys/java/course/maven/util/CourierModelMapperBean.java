package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;

public class CourierModelMapperBean extends CoreModelMapperBean<CourierModel, Courier> {
    @Override
    public CourierModel initNewModel() {
        return new CourierModel();
    }

    @Override
    public CourierModel createModelFromEntity(Courier entity) {
        CourierModel foodModel = super.createModelFromEntity(entity);
        foodModel.setFirstName(entity.getFirstName());
        foodModel.setLastName(entity.getLastName());
        foodModel.setPhoneNumber(entity.getPhoneNumber());
        return foodModel;
    }

    @Override
    public void populateEntityFromModel(Courier entity, CourierModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPhoneNumber(model.getPhoneNumber());
    }
}