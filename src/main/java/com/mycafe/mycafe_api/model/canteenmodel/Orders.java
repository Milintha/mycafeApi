package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycafe.mycafe_api.model.loginmodel.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Orders  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="order_id",updatable = false, nullable = false)
    private int order_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_category_id", referencedColumnName = "recipe_category_id")
    @JsonIgnore
    private RecipeCategory recipeCategory;

    @Column(name = "qty")
    private int qty;

    @Column(name = "order_type")
    private String order_type;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @JsonIgnore
    @OneToMany(
            mappedBy = "orders"
    )private List<OrdersComment> commentList=new ArrayList<>();

    public Orders(int order_id, User user, RecipeCategory recipeCategory, int qty, String order_type, String status, String date, String time, List<OrdersComment> commentList) {
        this.order_id = order_id;
        this.user = user;
        this.recipeCategory = recipeCategory;
        this.qty = qty;
        this.order_type = order_type;
        this.status = status;
        this.date = date;
        this.time = time;
        this.commentList = commentList;
    }

    public Orders( User user, RecipeCategory recipeCategory, int qty, String order_type, String status, String date, String time) {

        this.user = user;
        this.recipeCategory = recipeCategory;
        this.qty = qty;
        this.order_type = order_type;
        this.status = status;
        this.date = date;
        this.time = time;

    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

