package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycafe.mycafe_api.model.loginmodel.User;

import javax.persistence.*;

@Entity
@Table(name = "summary")
public class Summary {
    @Id
    @Column(name = " sum_id")
    private int sum_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;


    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "income")
    private float income;

    public Summary(int sum_id, User user, String date, String time, float income) {
        this.sum_id = sum_id;
        this.user = user;
        this.date = date;
        this.time = time;
        this.income = income;
    }

    public int getSum_id() {
        return sum_id;
    }

    public void setSum_id(int sum_id) {
        this.sum_id = sum_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
