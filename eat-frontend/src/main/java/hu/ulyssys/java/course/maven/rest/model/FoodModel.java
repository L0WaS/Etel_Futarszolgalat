package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class  FoodModel extends CoreRestModel {
    @NotNull
    @Size(max = 500)
    private String name;
    @NotNull
    @Size(max = 200)
    private String description;
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
}
