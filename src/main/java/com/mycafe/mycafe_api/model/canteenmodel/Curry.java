package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "curry")
public class Curry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "curry_id")
    private int curry_id;
    @Column(name = "curry_name")
    private String curry_name;
    @Column(name = "detail")
    private String detail;

    @JsonIgnore
    @OneToMany(
            mappedBy = "curry"
    )private List<MealContent> mealContentList=new ArrayList<>();


    public Curry() {

    }

    public Curry(int curry_id, String curry_name, String detail) {
        this.curry_id = curry_id;
        this.curry_name = curry_name;
        this.detail = detail;
    }

    public int getCurry_id() {
        return curry_id;
    }

    public void setCurry_id(int curry_id) {
        this.curry_id = curry_id;
    }

    public String getCurry_name() {
        return curry_name;
    }

    public void setCurry_name(String curry_name) {
        this.curry_name = curry_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<MealContent> getMealContentList() {
        return mealContentList;
    }

    public void setMealContentList(List<MealContent> mealContentList) {
        this.mealContentList = mealContentList;
    }
}
