package com.mycafe.mycafe_api.model.canteenmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id")
    private int comment_id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(
            mappedBy = "comment"
    )private List<OrdersComment> commentList=new ArrayList<>();

    public Comment(int comment_id, String date, String time, String description) {
        this.comment_id = comment_id;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrdersComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<OrdersComment> commentList) {
        this.commentList = commentList;
    }
}
