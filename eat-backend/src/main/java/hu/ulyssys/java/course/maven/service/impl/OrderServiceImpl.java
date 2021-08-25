package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.OrderService;

import javax.ejb.Stateless;

@Stateless
public class OrderServiceImpl extends CoreServiceImpl<Order> implements OrderService {
}
