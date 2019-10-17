package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="brand")
public class Brand  {
    @Id
    @Column(name = "brand_id")
    private int brand_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(
            mappedBy = "brand"
    )private List<FoodBrands> foodIdList= new ArrayList<>();

    public Brand() {
    }

    public Brand(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

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

    public List<FoodBrands> getFoodIdList() {
        return foodIdList;
    }

    public void setFoodIdList(List<FoodBrands> foodIdList) {
        this.foodIdList = foodIdList;
    }


}
