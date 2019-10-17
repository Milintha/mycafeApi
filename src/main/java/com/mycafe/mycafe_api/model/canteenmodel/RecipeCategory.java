package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe_category")
public class RecipeCategory {

    @Id
    @Column(name = "recipe_category_id ")
    private int recipe_category_id ;

    @ManyToOne(optional=false)
    @JoinColumn(name="recipe_id")
    Recipe recipe;

    @ManyToOne(optional=false)
    @JoinColumn(name = "category_id")
    Category category;

    public RecipeCategory() {
    }

    public RecipeCategory(Recipe recipe, Category category) {
        this.recipe = recipe;
        this.category = category;
    }

    public int getRecipe_category_id() {
        return recipe_category_id;
    }

    public void setRecipe_category_id(int recipe_category_id) {
        this.recipe_category_id = recipe_category_id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
