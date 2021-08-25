package hu.ulyssys.java.course.maven.entity;

import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;


@NamedQuery(name = Food.FIND_BY_USERNAME, query = "select u from Food u where u.name=:name ")
@Entity
@Table(name = "food")
public class Food extends AbstractEat {


    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static  final String FIND_BY_USERNAME = "Food.findByUsername";


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return price == food.price && Objects.equals(name, food.name) && Objects.equals(description, food.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
