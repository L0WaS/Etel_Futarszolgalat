package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.OrderDAO;
import hu.ulyssys.java.course.maven.entity.Order;

import javax.ejb.Stateless;

@Stateless
public class OrderDAOImpl extends CoreDAOImpl<Order> implements OrderDAO {

    @Override
    protected Class<Order> getManagedClass() {
        return Order.class;
    }
}
