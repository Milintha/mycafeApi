package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycafe.mycafe_api.model.loginmodel.User;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int employee_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = " name")
    private String name;

    @Column(name = " phone")
    private int phone;

    @Column(name = " address")
    private String address;

    public Employee() {
    }

    public Employee(int employee_id, User user, String name, int phone, String address) {
        this.employee_id = employee_id;
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
