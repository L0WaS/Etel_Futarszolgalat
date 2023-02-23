package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;
import hu.ulyssys.java.course.maven.util.OrderModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/order")
public class OrderRestService extends CoreRestService<Order, OrderModel> {
    @Inject
    private OrderModelMapperBean orderModelMapperBean;

    @Override
    protected void populateEntityFromModel(Order entity, OrderModel model) {
        orderModelMapperBean.populateEntityFromModel(entity, model);
    }

    @Override
    protected OrderModel createModelFromEntity(Order entity) {
        return orderModelMapperBean.createModelFromEntity(entity);
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }
}