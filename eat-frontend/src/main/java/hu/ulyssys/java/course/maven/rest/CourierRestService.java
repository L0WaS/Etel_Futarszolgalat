package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;
import hu.ulyssys.java.course.maven.util.CourierModelMapperBean;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/courier")
public class CourierRestService extends CoreRestService<Courier, CourierModel> {
    @Inject
    private CourierModelMapperBean courierModelMapperBean;


    @Override
    protected CourierModel createModelFromEntity(Courier entity) {
        return courierModelMapperBean.createModelFromEntity(entity);
    }

    @Override
    protected void populateEntityFromModel(Courier entity, CourierModel model) {
        courierModelMapperBean.populateEntityFromModel(entity, model);
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}