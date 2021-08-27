package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class OrderCRUDMbean extends AwareCRUDMbean<Order> implements Serializable {

    private List<Courier> courierList;

    private List<Food> foodList;

    private OrderService orderService;


    @Override
    protected String dialogName() {
        return "orderDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    @Override
    protected void refreshData() {
        if (!loggedInUserBean.isAdmin()) {
            setList(orderService.getAll().stream().filter(order -> order.getCreatedBy().getUserName().equals(loggedInUserBean.getModel().getUsername())).collect(Collectors.toList()));
        }else {
            setList(orderService.getAll());
        }
    }

    @Inject
    public OrderCRUDMbean(OrderService orderService, AppUserService appUserService, LoggedInUserBean loggedInUserBean, CourierService courierService, FoodService foodService) {
        super(orderService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isLoggedIn()){
            throw new SecurityException("Egy létező felhasználóval kell bejelentkezned a folytatáshoz!");
        }
        this.courierList = courierService.getAll();
        this.foodList = foodService.getAll();
        this.orderService = orderService;
        refreshData();
    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
