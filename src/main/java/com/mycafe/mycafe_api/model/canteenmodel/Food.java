package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycafe.mycafe_api.model.loginmodel.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food")
public class Food  {
    @Id
    @Column(name = "food_id")
    private int food_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(
            mappedBy = "food"
    )private List<FoodBrands> brandsIdList= new ArrayList<>();

    public Food() {
    }


    public Food(int food_id, User user, String name) {
        this.food_id = food_id;
        this.user = user;
        this.name = name;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodBrands> getBrandsIdList() {
        return brandsIdList;
    }

    public void setBrandsIdList(List<FoodBrands> brandsIdList) {
        this.brandsIdList = brandsIdList;
    }
}
