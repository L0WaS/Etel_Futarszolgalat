package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.FoodDAO;
import hu.ulyssys.java.course.maven.entity.Food;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class FoodDAOImpl extends CoreDAOImpl<Food> implements FoodDAO {
    @Override
    protected Class<Food> getManagedClass() {
        return Food.class;
    }

    @Override
    public Food findByUserName(String username) {
        TypedQuery<Food> query = entityManager.createNamedQuery(Food.FIND_BY_USERNAME, Food.class);
        query.setParameter("name", username);
        List<Food> foodList = query.getResultList();
        if(foodList.isEmpty()){
            return null;
        }
        return foodList.get(0);
    }
}
