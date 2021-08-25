package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.Food;

public interface FoodService extends CoreService<Food> {

    Food findByUserName(String username);

}
