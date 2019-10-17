package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycafe.mycafe_api.model.loginmodel.User;

import javax.persistence.*;
@Entity
@Table(name = "canteen")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Canteen  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="canteen_id")
    private int canteen_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Column(name="name")
    private String name;

    @Column(name="open")
    private String open;
    @Column(name="close")
    private String close;
    @Column(name="notice")
    private String notice;

    public Canteen() {
    }

    public Canteen(User user, String name, String open, String close, String notice) {
        this.user = user;
        this.name = name;
        this.open = open;
        this.close = close;
        this.notice = notice;
    }

    public int getCanteen_id() {
        return canteen_id;
    }

    public void setCanteen_id(int canteen_id) {
        this.canteen_id = canteen_id;
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

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
