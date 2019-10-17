package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pay_id")
    private int pay_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @JsonIgnore
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_method_id",referencedColumnName = "pay_method_id")
    @JsonIgnore
    private PaymentMethod paymentMethod;

    @Column(name = "amount")
    private float amount;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentId")
    private List<WalletHistory> walletHistoryList;

    public Payment() {
    }

    public Payment(int pay_id, Orders orders, PaymentMethod paymentMethod, float amount, String date, String time) {
        this.pay_id = pay_id;
        this.orders = orders;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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

    public List<WalletHistory> getWalletHistoryList() {
        return walletHistoryList;
    }

    public void setWalletHistoryList(List<WalletHistory> walletHistoryList) {
        this.walletHistoryList = walletHistoryList;
    }
}
