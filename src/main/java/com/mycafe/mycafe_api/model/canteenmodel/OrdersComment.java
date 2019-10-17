package com.mycafe.mycafe_api.model.canteenmodel;

import javax.persistence.*;

@Entity
@Table(name="orders_comment")
public class OrdersComment {
    @EmbeddedId
    private OrdersCommentId ordersCommentId;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name="order_id")
    Orders orders;

    @ManyToOne
    @MapsId("comment_id")
    @JoinColumn(name="comment_id")
    Comment comment;

    public OrdersComment() {
    }

    public OrdersComment(Orders orders, Comment comment) {
        this.orders = orders;
        this.comment = comment;
        this.ordersCommentId=new OrdersCommentId(orders.getOrder_id(),comment.getComment_id());
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

}
