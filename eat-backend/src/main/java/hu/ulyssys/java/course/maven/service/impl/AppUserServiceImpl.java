package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.dao.AppUserDAO;


import javax.ejb.Stateless;

@Stateless
public class AppUserServiceImpl extends CoreServiceImpl<AppUser> implements AppUserService {
    @Override
    public AppUser findByUserName(String username) {
        return ((AppUserDAO) dao).findByUserName(username);
    }
}