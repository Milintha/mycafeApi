package com.mycafe.mycafe_api.model.canteenmodel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MealContentId implements Serializable {
    @Column(name = "recipe_id")
    private int recipe_id;

    @Column(name = "curry_id")
    private int curry_id;

    private MealContentId(){

    }

    public MealContentId(int recipe_id, int curry_id) {
        this.recipe_id = recipe_id;
        this.curry_id = curry_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getCurry_id() {
        return curry_id;
    }

    public void setCurry_id(int curry_id) {
        this.curry_id = curry_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealContentId that = (MealContentId) o;
        return Objects.equals(recipe_id, that.recipe_id) &&
                Objects.equals(curry_id,that.curry_id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, curry_id);
    }
}
