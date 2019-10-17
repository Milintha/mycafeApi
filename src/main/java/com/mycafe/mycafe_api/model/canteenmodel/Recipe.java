package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycafe.mycafe_api.model.loginmodel.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
public  class Recipe {
    @Id
    @Column(name = "recipe_id")
    private int recipe_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "recipe_name")
    private String recipe_name;

    @Column(name = "date")
    private String date;

    @Column(name = "meal_time")
    private String meal_time;

    @Column(name = "price")
    private float price;

    @JsonIgnore
    @OneToMany(
            mappedBy = "recipe"
    )
    private List<MealContent> mealContentList=new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "recipe"
    )private List<RecipeCategory> categoryList=new ArrayList<>();

    public Recipe() {
    }

    public Recipe(int recipe_id,User user, String recipe_name, String date, String meal_time, float price) {
        this.recipe_id = recipe_id;
        this.user = user;
        this.recipe_name = recipe_name;
        this.date = date;
        this.meal_time = meal_time;
        this.price = price;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMeal_time() {
        return meal_time;
    }

    public void setMeal_time(String meal_time) {
        this.meal_time = meal_time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<MealContent> getMealContentList() {
        return mealContentList;
    }

    public void setMealContentList(List<MealContent> mealContentList) {
        this.mealContentList = mealContentList;
    }

    public List<RecipeCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<RecipeCategory> categoryList) {
        this.categoryList = categoryList;
    }
}

