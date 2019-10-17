package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "wallet_history")
public class WalletHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "history_id")
    private int history_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id",referencedColumnName = "wallet_id")
    @JsonIgnore
    private Wallet wallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_id",referencedColumnName = "pay_id")
    @JsonIgnore
    private Payment paymentId;

    @Column(name = "payment")
    private float payment;

    @Column(name = "method")
    private String method;

    @Column(name = "date")
    private int date;

    @Column(name = "time")
    private int time;

    public WalletHistory() {
    }

    public WalletHistory(int history_id, Wallet wallet, Payment paymentId, float payment, String method, int date, int time) {
        this.history_id = history_id;
        this.wallet = wallet;
        this.paymentId = paymentId;
        this.payment = payment;
        this.method = method;
        this.date = date;
        this.time = time;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
