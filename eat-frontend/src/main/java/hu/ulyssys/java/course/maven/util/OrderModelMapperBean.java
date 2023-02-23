package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.FoodService;
import hu.ulyssys.java.course.maven.util.CoreModelMapperBean;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class OrderModelMapperBean extends CoreModelMapperBean<OrderModel, Order> {

    @Inject
    private CourierService courierService;

    @Inject
    private FoodService foodService;

    @Override
    public OrderModel initNewModel() {
        return new OrderModel();
    }
    @Override
    public OrderModel createModelFromEntity(Order entity) {
        OrderModel foodModel = super.createModelFromEntity(entity);
        foodModel.setDeliveredDate(entity.getDeliveredDate());
        if (entity.getCourier() != null) {
            foodModel.setCourier(entity.getCourier().getId());
        }else {
            foodModel.setCourier(null);
        }
        foodModel.setFoods(entity.getFoods().stream().map(AbstractEntity::getId).collect(Collectors.toList()));
        foodModel.setSettlement(entity.getSettlement());
        foodModel.setPublicSpace(entity.getPublicSpace());
        foodModel.setNatureOfPublicSpace(entity.getNatureOfPublicSpace());
        foodModel.setHouseNumber(entity.getHouseNumber());
        return foodModel;
    }

    @Override
    public void populateEntityFromModel(Order entity, OrderModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setDeliveredDate(model.getDeliveredDate());
        if (model.getCourier() != null) {
            entity.setCourier(courierService.findById(model.getCourier()));
        }
        if (model.getFoods() != null) {
            entity.setFoods(model.getFoods().stream().map(food -> foodService.findById(food)).collect(Collectors.toList()));
        }
        entity.setSettlement(model.getSettlement());
        entity.setPublicSpace(model.getPublicSpace());
        entity.setNatureOfPublicSpace(model.getNatureOfPublicSpace());
        entity.setHouseNumber(model.getHouseNumber());
    }
}