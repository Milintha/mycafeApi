package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "description")
    private String description;

    @Column(name = "add_amount")
    private float add_amount;

    @JsonIgnore
    @OneToMany(
            mappedBy = "category"
    )private List<RecipeCategory> categoryList=new ArrayList<>();

    public Category() {
    }

    public Category(int category_id, String description, float add_amount) {
        this.category_id = category_id;
        this.description = description;
        this.add_amount = add_amount;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAdd_amount() {
        return add_amount;
    }

    public void setAdd_amount(float add_amount) {
        this.add_amount = add_amount;
    }
}
