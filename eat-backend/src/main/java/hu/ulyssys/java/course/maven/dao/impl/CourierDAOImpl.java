package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CourierDAO;
import hu.ulyssys.java.course.maven.entity.Courier;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CourierDAOImpl extends CoreDAOImpl<Courier> implements CourierDAO {

    @Override
    public Courier findByUserName(String firstName, String lastName) {
        TypedQuery<Courier> query = entityManager.createNamedQuery(Courier.FIND_BY_USERNAME, Courier.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        List<Courier> courierList = query.getResultList();
        if(courierList.isEmpty()){
            return null;
        }
        return courierList.get(0);
    }

    @Override
    protected Class<Courier> getManagedClass() {
        return Courier.class;
    }
}