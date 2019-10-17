package com.mycafe.mycafe_api.model.canteenmodel;

import javax.persistence.*;

@Entity
@Table(name = "food_brands")
public class FoodBrands {
    @EmbeddedId
    FoodBrandsId food_brands_id;

    @ManyToOne
    @MapsId("food_id")
    @JoinColumn(name="food_id")
    Food food;

    @ManyToOne
    @MapsId("brand_id")
    @JoinColumn(name = "brand_id")
    Brand brand;

    @Column(name="price")
    private float price;

    @Column(name="qty")
    private int qty;

    public FoodBrands() {
    }

    public FoodBrands(Food food, Brand brand, float price, int qty) {

        this.food = food;
        this.brand = brand;
        this.price = price;
        this.qty = qty;
        this.food_brands_id=new FoodBrandsId(food.getFood_id(),brand.getBrand_id());
    }

    public FoodBrandsId getFood_brands_id() {
        return food_brands_id;
    }

    public void setFood_brands_id(FoodBrandsId food_brands_id) {
        this.food_brands_id = food_brands_id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
