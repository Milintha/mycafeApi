package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycafe.mycafe_api.model.loginmodel.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "wallet_id")
    private int wallet_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "date")
    private String date;

    @Column(name = "balance")
    private float balance;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wallet")
    private List<WalletHistory> walletHistoryList;


    public Wallet() {

    }

    public Wallet(int wallet_id, User user, String date, float balance) {
        this.wallet_id = wallet_id;
        this.user = user;
        this.date = date;
        this.balance = balance;
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
