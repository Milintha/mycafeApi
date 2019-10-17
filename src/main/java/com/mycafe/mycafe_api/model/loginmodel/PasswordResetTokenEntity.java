package com.mycafe.mycafe_api.model.loginmodel;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "password_reset_token")
public class PasswordResetTokenEntity implements Serializable {
    private static final long serialVersionUID = 2229380990684944907L;

    @Id
    @GeneratedValue
    private Long id;

    private  String token;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
