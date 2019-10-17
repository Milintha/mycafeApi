package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pay_method_id")
    private int pay_method_id;

    @Column(name = "method_desc")
    private String method_desc;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMethod")
    private List<Payment> paymentList;

    public PaymentMethod() {
    }

    public PaymentMethod(int pay_method_id, String method_desc) {
        this.pay_method_id = pay_method_id;
        this.method_desc = method_desc;
    }

    public int getPay_method_id() {
        return pay_method_id;
    }

    public void setPay_method_id(int pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public String getMethod_desc() {
        return method_desc;
    }

    public void setMethod_desc(String method_desc) {
        this.method_desc = method_desc;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
