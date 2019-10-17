package com.mycafe.mycafe_api.payloads;


import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.canteenmodel.RecipeCategory;
import com.mycafe.mycafe_api.model.loginmodel.User;

public class OrderDetailDTO {
    private RecipeCategory recipeCategory;
    private User user;
    private int qty;
    private String orderType;//identify vegi or non vegi. but it define in category. put null for now;
    private Payment payment;

    public OrderDetailDTO(RecipeCategory recipeCategory, User user, int qty, String orderType, Payment payment) {
        this.recipeCategory = recipeCategory;
        this.user = user;
        this.qty = qty;
        this.orderType = orderType;
        this.payment = payment;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public User getAuthUserRole() {
        return user;
    }

    public void setAuthUserRole(User authUserRole) {
        this.user = authUserRole;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
