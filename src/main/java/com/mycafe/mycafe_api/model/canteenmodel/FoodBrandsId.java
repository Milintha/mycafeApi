package com.mycafe.mycafe_api.model.canteenmodel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class FoodBrandsId implements Serializable {
    @Column(name = "food_id")
    private int food_id;

    @Column(name = "brand_id")
    private int brand_id;

    private FoodBrandsId(){

    }

    public FoodBrandsId(int food_id, int brand_id) {
        this.food_id = food_id;
        this.brand_id = brand_id;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }

        if(o==null || getClass() != o.getClass()){
            return false;
        }

        FoodBrandsId that=(FoodBrandsId)o;
        return Objects.equals(food_id,that.food_id) && Objects.equals(brand_id,that.brand_id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(food_id, brand_id);
    }
}
