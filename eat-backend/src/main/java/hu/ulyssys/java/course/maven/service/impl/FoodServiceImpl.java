package hu.ulyssys.java.course.maven.service.impl;



import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.service.FoodService;
import hu.ulyssys.java.course.maven.dao.FoodDAO;
import javax.ejb.Stateless;

@Stateless
public class FoodServiceImpl extends CoreServiceImpl<Food> implements FoodService {
    @Override
    public Food findByUserName(String username) {
        return ((FoodDAO) dao).findByUserName(username);
    }
}
