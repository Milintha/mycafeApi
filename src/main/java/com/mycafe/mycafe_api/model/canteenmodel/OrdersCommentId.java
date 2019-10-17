package com.mycafe.mycafe_api.model.canteenmodel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrdersCommentId implements Serializable {
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "comment_id")
    private int comment_id;

    public OrdersCommentId() {
    }

    public OrdersCommentId(int order_id, int comment_id) {
        this.order_id = order_id;
        this.comment_id = comment_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

}
