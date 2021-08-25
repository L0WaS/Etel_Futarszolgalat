package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.dao.CourierDAO;


import javax.ejb.Stateless;


@Stateless
public class CourierServiceImpl extends CoreServiceImpl<Courier> implements CourierService {
    @Override
    public Courier findByUserName(String firstName, String lastName) {
        return ((CourierDAO) dao).findByUserName(firstName, lastName);
    }
}
