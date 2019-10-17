package com.mycafe.mycafe_api.model.canteenmodel;

import javax.persistence.*;

@Entity
@Table(name = "meal_content")
public class MealContent {
    @EmbeddedId
    private MealContentId mealContentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipe_id")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("curry_id")
    private Curry curry;

    public MealContent() {
    }

    public MealContent(Recipe recipe,Curry curry) {
        this.recipe=recipe;
        this.curry=curry;
        this.mealContentId=new MealContentId(recipe.getRecipe_id(),curry.getCurry_id());
    }

    public MealContentId getMealContentId() {
        return mealContentId;
    }

    public void setMealContentId(MealContentId mealContentId) {
        this.mealContentId = mealContentId;
    }


    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Curry getCurry() {
        return curry;
    }

    public void setCurry(Curry curry) {
        this.curry = curry;
    }
}
